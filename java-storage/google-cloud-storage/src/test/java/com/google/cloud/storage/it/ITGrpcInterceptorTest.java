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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.GrpcStorageOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.common.collect.ImmutableList;
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
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public class ITGrpcInterceptorTest {
  private static final Metadata.Key<String> X_GOOG_REQUEST_PARAMS =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);

  @Inject
  @StorageFixture(Transport.GRPC)
  public Storage storage;

  @Inject public BucketInfo bucket;

  @Test
  public void grpcStorageOptions_allowSpecifyingInterceptor() throws Exception {
    TracerFactory factory = new TracerFactory();
    Interceptor interceptor = new Interceptor(factory);
    StorageOptions options =
        ((GrpcStorageOptions) storage.getOptions())
            .toBuilder().setGrpcInterceptorProvider(() -> ImmutableList.of(interceptor)).build();

    try (Storage storage = options.getService()) {
      Page<Bucket> page = storage.list(BucketListOption.prefix(bucket.getName()));
      List<String> bucketNames =
          page.streamAll().map(BucketInfo::getName).collect(Collectors.toList());
      assertThat(bucketNames).contains(bucket.getName());
    }

    assertThat(factory.metadatas).isNotEmpty();
    List<String> requestParams =
        factory.metadatas.stream()
            .map(m -> m.get(X_GOOG_REQUEST_PARAMS))
            .collect(Collectors.toList());

    String expected = String.format(Locale.US, "project=projects/%s", options.getProjectId());
    String expectedEncoded =
        String.format(Locale.US, "project=projects%%2F%s", options.getProjectId());
    assertThat(requestParams).containsAnyOf(expected, expectedEncoded);
  }

  private static final class Interceptor implements ClientInterceptor {

    private final TracerFactory factory;

    public Interceptor(TracerFactory factory) {
      this.factory = factory;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      CallOptions callOptions1 = callOptions.withStreamTracerFactory(factory);
      return next.newCall(method, callOptions1);
    }
  }

  private static final class TracerFactory extends ClientStreamTracer.Factory {

    private final List<Metadata> metadatas = Collections.synchronizedList(new ArrayList<>());

    @Override
    public ClientStreamTracer newClientStreamTracer(StreamInfo info, Metadata headers) {
      return new ClientStreamTracer() {
        @Override
        public void streamCreated(Attributes transportAttrs, Metadata headers) {
          metadatas.add(headers);
        }
      };
    }
  }
}
