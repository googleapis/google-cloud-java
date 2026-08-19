/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.sql.v1beta4.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.sql.v1beta4.ConnectSettings;
import com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest;
import com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse;
import com.google.cloud.sql.v1beta4.GetConnectSettingsRequest;
import com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SqlConnectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SqlConnectServiceStub implements BackgroundResource {

  public UnaryCallable<GetConnectSettingsRequest, ConnectSettings> getConnectSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectSettingsCallable()");
  }

  public UnaryCallable<ResolveConnectSettingsRequest, ConnectSettings>
      resolveConnectSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: resolveConnectSettingsCallable()");
  }

  public UnaryCallable<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
      generateEphemeralCertCallable() {
    throw new UnsupportedOperationException("Not implemented: generateEphemeralCertCallable()");
  }

  @Override
  public abstract void close();
}
