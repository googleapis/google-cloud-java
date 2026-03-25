/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.grpc.testing;

import com.google.api.core.BetaApi;
import io.grpc.MethodDescriptor;
import java.io.InputStream;

@BetaApi
public class FakeMethodDescriptor {
  // Utility class, uninstantiable.
  private FakeMethodDescriptor() {}

  public static <I, O> MethodDescriptor<I, O> create() {
    return create(MethodDescriptor.MethodType.UNARY, "FakeClient/fake-method");
  }

  public static <I, O> MethodDescriptor<I, O> create(
      MethodDescriptor.MethodType type, String name) {
    return MethodDescriptor.<I, O>newBuilder()
        .setType(MethodDescriptor.MethodType.UNARY)
        .setFullMethodName(name)
        .setRequestMarshaller(new FakeMarshaller<I>())
        .setResponseMarshaller(new FakeMarshaller<O>())
        .build();
  }

  private static class FakeMarshaller<T> implements MethodDescriptor.Marshaller<T> {
    @Override
    public T parse(InputStream stream) {
      throw new UnsupportedOperationException("FakeMarshaller doesn't actually do anything");
    }

    @Override
    public InputStream stream(T value) {
      throw new UnsupportedOperationException("FakeMarshaller doesn't actually do anything");
    }
  }
}
