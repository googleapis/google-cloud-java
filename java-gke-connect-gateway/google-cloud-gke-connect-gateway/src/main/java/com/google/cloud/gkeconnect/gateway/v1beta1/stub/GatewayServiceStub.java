/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.gkeconnect.gateway.v1beta1.stub;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GatewayService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class GatewayServiceStub implements BackgroundResource {

  public UnaryCallable<HttpBody, HttpBody> getResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getResourceCallable()");
  }

  public UnaryCallable<HttpBody, HttpBody> postResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: postResourceCallable()");
  }

  public UnaryCallable<HttpBody, HttpBody> deleteResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteResourceCallable()");
  }

  public UnaryCallable<HttpBody, HttpBody> putResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: putResourceCallable()");
  }

  public UnaryCallable<HttpBody, HttpBody> patchResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: patchResourceCallable()");
  }

  @Override
  public abstract void close();
}
