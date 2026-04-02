/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.spanner.v1.SpannerSettings;

public final class TestChannelProvider implements ConnectionOptions.ExternalChannelProvider {
  public TransportChannelProvider getChannelProvider(String host, int port) {
    return SpannerSettings.defaultTransportChannelProvider();
  }
}
