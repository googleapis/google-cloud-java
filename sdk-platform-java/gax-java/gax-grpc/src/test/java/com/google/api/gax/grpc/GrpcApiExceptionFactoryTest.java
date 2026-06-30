/*
 * Copyright 2022 Google LLC
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
package com.google.api.gax.grpc;

import static com.google.api.gax.grpc.GrpcApiExceptionFactory.ERROR_DETAIL_KEY;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.rpc.ErrorInfo;
import com.google.rpc.RetryInfo;
import com.google.rpc.Status;
import io.grpc.Metadata;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrpcApiExceptionFactoryTest {

  private static final ErrorInfo ERROR_INFO =
      ErrorInfo.newBuilder()
          .setDomain("googleapis.com")
          .setReason("SERVICE_DISABLED")
          .putAllMetadata(Collections.emptyMap())
          .build();

  private static final RetryInfo RETRY_INFO =
      RetryInfo.newBuilder().setRetryDelay(Duration.newBuilder().setSeconds(213).build()).build();

  private static final ImmutableList<Any> RAW_ERROR_MESSAGES =
      ImmutableList.of(Any.pack(ERROR_INFO), Any.pack(RETRY_INFO));

  private static final ErrorDetails ERROR_DETAILS =
      ErrorDetails.builder().setRawErrorMessages(RAW_ERROR_MESSAGES).build();

  private static final io.grpc.Status GRPC_STATUS = io.grpc.Status.CANCELLED;

  private GrpcApiExceptionFactory factory;

  @BeforeEach
  void setUp() throws Exception {
    factory = new GrpcApiExceptionFactory(Collections.emptySet());
  }

  @Test
  void create_shouldCreateApiExceptionWithErrorDetailsForStatusException() {
    Metadata trailers = new Metadata();
    Status status = Status.newBuilder().addAllDetails(RAW_ERROR_MESSAGES).build();
    trailers.put(
        Metadata.Key.of(ERROR_DETAIL_KEY, Metadata.BINARY_BYTE_MARSHALLER), status.toByteArray());
    StatusException statusException = new StatusException(GRPC_STATUS, trailers);

    ApiException actual = factory.create(statusException);

    Truth.assertThat(actual.getErrorDetails()).isEqualTo(ERROR_DETAILS);
  }

  @Test
  void create_shouldCreateApiExceptionWithErrorDetailsForStatusRuntimeException() {
    Metadata trailers = new Metadata();
    Status status = Status.newBuilder().addAllDetails(RAW_ERROR_MESSAGES).build();
    trailers.put(
        Metadata.Key.of(ERROR_DETAIL_KEY, Metadata.BINARY_BYTE_MARSHALLER), status.toByteArray());
    StatusRuntimeException statusException = new StatusRuntimeException(GRPC_STATUS, trailers);

    ApiException actual = factory.create(statusException);

    Truth.assertThat(actual.getErrorDetails()).isEqualTo(ERROR_DETAILS);
  }

  @Test
  void create_shouldCreateApiExceptionWithNoErrorDetailsIfMetadataIsNull() {
    StatusRuntimeException statusException = new StatusRuntimeException(GRPC_STATUS, null);

    ApiException actual = factory.create(statusException);

    Truth.assertThat(actual.getErrorDetails()).isNull();
  }

  @Test
  void create_shouldCreateApiExceptionWithNoErrorDetailsIfMetadataDoesNotHaveErrorDetails() {
    StatusRuntimeException statusException =
        new StatusRuntimeException(GRPC_STATUS, new Metadata());

    ApiException actual = factory.create(statusException);

    Truth.assertThat(actual.getErrorDetails()).isNull();
  }

  @Test
  void create_shouldCreateApiExceptionWithNoErrorDetailsIfStatusIsMalformed() {
    Metadata trailers = new Metadata();
    Status status = Status.newBuilder().addDetails(Any.pack(ERROR_INFO)).build();
    byte[] bytes = status.toByteArray();
    // manually manipulate status bytes array
    bytes[0] = 123;
    trailers.put(Metadata.Key.of(ERROR_DETAIL_KEY, Metadata.BINARY_BYTE_MARSHALLER), bytes);
    StatusRuntimeException statusException = new StatusRuntimeException(GRPC_STATUS, trailers);

    ApiException actual = factory.create(statusException);

    Truth.assertThat(actual.getErrorDetails()).isNull();
  }
}
