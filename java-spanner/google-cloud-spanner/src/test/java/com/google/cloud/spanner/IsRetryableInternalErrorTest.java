/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.InternalException;
import com.google.common.base.Predicate;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IsRetryableInternalErrorTest {

  private Predicate<Throwable> predicate;

  @Before
  public void setUp() {
    predicate = new IsRetryableInternalError();
  }

  @Test
  public void http2ErrorStatusRuntimeExceptionIsRetryable() {
    final StatusRuntimeException e =
        new StatusRuntimeException(
            Status.fromCode(Code.INTERNAL)
                .withDescription("INTERNAL: HTTP/2 error code: INTERNAL_ERROR."));

    assertThat(predicate.apply(e)).isTrue();
  }

  @Test
  public void http2ErrorInternalExceptionIsRetryable() {
    final InternalException e =
        new InternalException(
            "INTERNAL: HTTP/2 error code: INTERNAL_ERROR.",
            null,
            GrpcStatusCode.of(Code.INTERNAL),
            false);

    assertThat(predicate.apply(e)).isTrue();
  }

  @Test
  public void connectionClosedStatusRuntimeExceptionIsRetryable() {
    final StatusRuntimeException e =
        new StatusRuntimeException(
            Status.fromCode(Code.INTERNAL)
                .withDescription("INTERNAL: Connection closed with unknown cause."));

    assertThat(predicate.apply(e)).isTrue();
  }

  @Test
  public void connectionClosedInternalExceptionIsRetryable() {
    final InternalException e =
        new InternalException(
            "INTERNAL: Connection closed with unknown cause.",
            null,
            GrpcStatusCode.of(Code.INTERNAL),
            false);

    assertThat(predicate.apply(e)).isTrue();
  }

  @Test
  public void eosStatusRuntimeExceptionIsRetryable() {
    final StatusRuntimeException e =
        new StatusRuntimeException(
            Status.fromCode(Code.INTERNAL)
                .withDescription("INTERNAL: Received unexpected EOS on DATA frame from server."));

    assertThat(predicate.apply(e)).isTrue();
  }

  @Test
  public void eosInternalExceptionIsRetryable() {
    final InternalException e =
        new InternalException(
            "INTERNAL: Received unexpected EOS on DATA frame from server.",
            null,
            GrpcStatusCode.of(Code.INTERNAL),
            false);

    assertThat(predicate.apply(e)).isTrue();
  }

  @Test
  public void genericInternalStatusRuntimeExceptionIsRetryable() {
    final StatusRuntimeException e =
        new StatusRuntimeException(
            Status.fromCode(Code.INTERNAL).withDescription("INTERNAL: Generic."));

    assertThat(predicate.apply(e)).isFalse();
  }

  @Test
  public void rstStreamInternalExceptionIsRetryable() {
    final InternalException e =
        new InternalException(
            "INTERNAL: stream terminated by RST_STREAM.",
            null,
            GrpcStatusCode.of(Code.INTERNAL),
            false);

    assertTrue(predicate.apply(e));
  }

  @Test
  public void testAuthenticationBackendInternalServerErrorIsRetryable() {
    final StatusRuntimeException exception =
        new StatusRuntimeException(
            Status.fromCode(Code.INTERNAL)
                .withDescription(
                    "INTERNAL: Authentication backend internal server error. Please retry."));

    assertTrue(predicate.apply(exception));
  }

  @Test
  public void genericInternalExceptionIsNotRetryable() {
    final InternalException e =
        new InternalException("INTERNAL: Generic.", null, GrpcStatusCode.of(Code.INTERNAL), false);

    assertThat(predicate.apply(e)).isFalse();
  }

  @Test
  public void nullIsNotRetryable() {
    assertThat(predicate.apply(null)).isFalse();
  }

  @Test
  public void genericExceptionIsNotRetryable() {
    assertThat(predicate.apply(new Exception())).isFalse();
  }
}
