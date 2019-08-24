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

package com.google.grpc.gcp;

import com.google.common.annotations.VisibleForTesting;
import com.google.grpc.gcp.proto.ApiConfig;
import com.google.protobuf.util.JsonFormat;
import io.grpc.ForwardingChannelBuilder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class GcpManagedChannelBuilder extends ForwardingChannelBuilder<GcpManagedChannelBuilder> {

  private static final Logger logger = Logger.getLogger(GcpManagedChannelBuilder.class.getName());

  private final ManagedChannelBuilder delegate;

  @VisibleForTesting
  ApiConfig apiConfig;

  private GcpManagedChannelBuilder(ManagedChannelBuilder delegate) {
    this.delegate = delegate;
  }

  private ApiConfig parseConfigFromJsonFile(File file) {
    JsonFormat.Parser parser = JsonFormat.parser();
    ApiConfig.Builder apiConfig = ApiConfig.newBuilder();
    try {
      FileReader reader = new FileReader(file);
      parser.merge(reader, apiConfig);
    } catch (IOException e) {
      logger.severe(e.getMessage());
      return null;
    }
    return apiConfig.build();
  }

  public static final GcpManagedChannelBuilder forDelegateBuilder(ManagedChannelBuilder delegate) {
    return new GcpManagedChannelBuilder(delegate);
  }

  public GcpManagedChannelBuilder withApiConfig(ApiConfig apiConfig) {
    this.apiConfig = apiConfig;
    return this;
  }

  public GcpManagedChannelBuilder withApiConfigJsonFile(File file) {
    this.apiConfig = parseConfigFromJsonFile(file);
    return this;
  }

  /**
   * Returns the delegated {@code ManagedChannelBuilder}.
   */
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
    return new GcpManagedChannel(delegate, apiConfig);
  }

}
