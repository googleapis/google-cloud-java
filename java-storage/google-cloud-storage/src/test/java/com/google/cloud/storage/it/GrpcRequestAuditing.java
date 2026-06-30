/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.IterableSubject;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientStreamTracer;
import io.grpc.ClientStreamTracer.StreamInfo;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class GrpcRequestAuditing
    implements ClientInterceptor, AssertRequestHeaders, GrpcInterceptorProvider {

  private final List<Metadata> requestHeaders;

  public GrpcRequestAuditing() {
    requestHeaders = Collections.synchronizedList(new ArrayList<>());
  }

  public void clear() {
    requestHeaders.clear();
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    CallOptions withStreamTracerFactory = callOptions.withStreamTracerFactory(new Factory());
    return next.newCall(method, withStreamTracerFactory);
  }

  @Override
  public IterableSubject assertRequestHeader(String headerName, FilteringPolicy filteringPolicy) {
    Metadata.Key<String> key = Metadata.Key.of(headerName, Metadata.ASCII_STRING_MARSHALLER);
    Function<Stream<String>, Stream<String>> filter;
    switch (filteringPolicy) {
      case DISTINCT:
        filter = Stream::distinct;
        break;
      case NO_FILTER:
        filter = Function.identity();
        break;
      default:
        throw new IllegalStateException("Unhandled enum value: " + filteringPolicy);
    }
    return getIterableSubject(key, filter);
  }

  public <T> IterableSubject assertRequestHeader(Metadata.Key<T> key) {
    return getIterableSubject(key, Stream::distinct);
  }

  private <T> @NonNull IterableSubject getIterableSubject(
      Metadata.Key<T> key, Function<Stream<T>, Stream<T>> f) {
    Stream<T> stream = requestHeaders.stream().map(m -> m.get(key)).filter(Objects::nonNull);
    ImmutableList<Object> actual = f.apply(stream).collect(ImmutableList.toImmutableList());
    return assertWithMessage(String.format(Locale.US, "Headers %s", key.name())).that(actual);
  }

  @Override
  public List<ClientInterceptor> getInterceptors() {
    return ImmutableList.of(this);
  }

  private final class Factory extends ClientStreamTracer.Factory {
    @Override
    public ClientStreamTracer newClientStreamTracer(StreamInfo info, Metadata headers) {
      return new Tracer();
    }
  }

  private final class Tracer extends ClientStreamTracer {

    @Override
    public void streamCreated(Attributes transportAttrs, Metadata headers) {
      requestHeaders.add(headers);
    }
  }
}
