/*
 * Copyright 2024 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.tracing;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.StubSettings;
import com.google.auto.value.AutoValue;

/** A value class to represent the name of the RPC method in an {@link ApiTracer}. */
@BetaApi
@InternalApi
@AutoValue
public abstract class MethodName {
  /**
   * Creates a new instance of the RPC method name.
   *
   * @param serviceName The name of the service. In general this will be GAPIC generated service
   *     name {@link StubSettings#getServiceName()}. However, in some cases, when the GAPIC
   *     generated service is wrapped, this will be overridden to specify the manually written
   *     wrapper's name.
   * @param methodName The name of the logical operation being traced.
   */
  public static MethodName of(String serviceName, String methodName) {
    return new AutoValue_MethodName(serviceName, methodName);
  }

  /** The name of the service. ie BigtableData */
  public abstract String getServiceName();

  /** The name of the logical operation being traced. ie. ReadRows. */
  public abstract String getMethodName();

  @Override
  public String toString() {
    return getServiceName() + "." + getMethodName();
  }
}
