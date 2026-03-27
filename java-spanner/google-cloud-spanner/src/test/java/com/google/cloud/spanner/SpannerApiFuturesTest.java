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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.ForwardingApiFuture;
import java.util.concurrent.CancellationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpannerApiFuturesTest {

  @Test
  public void testGet() {
    ApiFuture<Long> fut = ApiFutures.immediateFuture(1L);
    assertThat(get(fut)).isEqualTo(1L);
  }

  @Test
  public void testGetNull() {
    assertThrows(NullPointerException.class, () -> get(null));
  }

  @Test
  public void testGetOrNull() {
    assertThat(SpannerApiFutures.getOrNull((ApiFuture<Object>) null)).isNull();
  }

  @Test
  public void testGetSpannerException() {
    ApiFuture<Void> fut =
        ApiFutures.immediateFailedFuture(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.FAILED_PRECONDITION, "test exception"));
    SpannerException e = assertThrows(SpannerException.class, () -> get(fut));
    assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    assertThat(e.getMessage()).contains("test exception");
  }

  @Test
  public void testGetOtherException() {
    ApiFuture<Void> fut =
        ApiFutures.immediateFailedFuture(new RuntimeException("test runtime exception"));
    SpannerException e = assertThrows(SpannerException.class, () -> get(fut));
    assertEquals(ErrorCode.UNKNOWN, e.getErrorCode());
    assertThat(e.getMessage()).contains("test runtime exception");
  }

  @Test
  public void testGetInterruptedException() {
    ApiFuture<Void> fut =
        new ForwardingApiFuture<Void>(ApiFutures.immediateFuture(null)) {
          public Void get() throws InterruptedException {
            throw new InterruptedException("test interrupted exception");
          }
        };
    SpannerException e = assertThrows(SpannerException.class, () -> get(fut));
    assertEquals(ErrorCode.CANCELLED, e.getErrorCode());
    // The message of an interrupted exception is not included in the SpannerException.
    assertThat(e.getMessage()).doesNotContain("test interrupted exception");
  }

  @Test
  public void testGetCancellationException() {
    ApiFuture<Void> fut =
        new ForwardingApiFuture<Void>(ApiFutures.immediateFuture(null)) {
          public Void get() {
            throw new CancellationException("test cancellation exception");
          }
        };
    SpannerException e = assertThrows(SpannerException.class, () -> get(fut));
    assertEquals(ErrorCode.CANCELLED, e.getErrorCode());
    // The message of an cancellation exception is included in the SpannerException.
    assertThat(e.getMessage()).contains("test cancellation exception");
  }
}
