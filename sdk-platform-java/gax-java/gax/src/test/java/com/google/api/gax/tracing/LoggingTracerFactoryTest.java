/*
 * Copyright 2026 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LoggingTracerFactoryTest {

  @Test
  void testNewTracer_CreatesLoggingTracer() {
    LoggingTracerFactory factory = new LoggingTracerFactory();
    ApiTracer tracer =
        factory.newTracer(
            BaseApiTracer.getInstance(),
            SpanName.of("client", "method"),
            ApiTracerFactory.OperationType.Unary);

    assertNotNull(tracer);
    assertTrue(tracer instanceof LoggingTracer);
  }

  @Test
  void testNewTracer_WithContext_CreatesLoggingTracer() {
    LoggingTracerFactory factory = new LoggingTracerFactory();
    ApiTracer tracer = factory.newTracer(BaseApiTracer.getInstance(), ApiTracerContext.empty());

    assertNotNull(tracer);
    assertTrue(tracer instanceof LoggingTracer);
  }

  @Test
  void testWithContext_ReturnsNewFactoryWithMergedContext() {
    LoggingTracerFactory factory = new LoggingTracerFactory();
    ApiTracerContext context =
        ApiTracerContext.empty().toBuilder().setServerAddress("address").build();
    ApiTracerFactory updatedFactory = factory.withContext(context);

    assertNotNull(updatedFactory);
    assertTrue(updatedFactory instanceof LoggingTracerFactory);
    assertEquals("address", updatedFactory.getApiTracerContext().serverAddress());
  }
}
