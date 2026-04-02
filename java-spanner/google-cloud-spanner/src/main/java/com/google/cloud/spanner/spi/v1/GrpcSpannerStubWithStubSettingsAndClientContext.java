/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.gax.rpc.ClientContext;
import com.google.cloud.spanner.v1.stub.GrpcSpannerStub;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import java.io.IOException;

/**
 * Wrapper around {@link GrpcSpannerStub} to make the constructor available inside this package.
 * This makes it possible to create a {@link GrpcSpannerStub} with a {@link SpannerStubSettings} and
 * a {@link ClientContext}.
 */
class GrpcSpannerStubWithStubSettingsAndClientContext extends GrpcSpannerStub {

  static final GrpcSpannerStubWithStubSettingsAndClientContext create(
      SpannerStubSettings settings, ClientContext clientContext) throws IOException {
    return new GrpcSpannerStubWithStubSettingsAndClientContext(settings, clientContext);
  }

  protected GrpcSpannerStubWithStubSettingsAndClientContext(
      SpannerStubSettings settings, ClientContext clientContext) throws IOException {
    super(settings, clientContext);
  }
}
