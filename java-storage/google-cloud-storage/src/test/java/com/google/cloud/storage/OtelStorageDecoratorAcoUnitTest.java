/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import org.junit.Test;
import org.mockito.Mockito;

public class OtelStorageDecoratorAcoUnitTest {

  @Test
  public void testCacheAndProxyDecorationFlow() throws Exception {
    Storage mockStorage =
        mock(Storage.class, Mockito.withSettings().extraInterfaces(StorageInternal.class));
    StorageInternal mockInternal = (StorageInternal) mockStorage;

    BucketMetadataCache cache = new BucketMetadataCache(10000);
    Mockito.when(mockInternal.getBucketMetadataCache()).thenReturn(cache);

    OpenTelemetry mockOtel = mock(OpenTelemetry.class);
    Tracer mockTracer = mock(Tracer.class);
    SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
    Span mockSpan = mock(Span.class);

    Mockito.when(mockOtel.getTracer(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(mockTracer);
    Mockito.when(mockTracer.spanBuilder(Mockito.anyString())).thenReturn(mockSpanBuilder);
    Mockito.when(mockSpanBuilder.setAllAttributes(Mockito.any())).thenReturn(mockSpanBuilder);
    Mockito.when(mockSpanBuilder.startSpan()).thenReturn(mockSpan);

    Storage decoratedStorage = OtelStorageDecorator.decorate(mockStorage, mockOtel, TransportCompatibility.Transport.HTTP);
    assertNotNull(decoratedStorage);

    OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;
    osd.checkCacheAndTriggerFetch("test-poc-bucket");

    BucketMetadataCache.BucketMetadata meta = cache.get("test-poc-bucket");
    assertNotNull(meta);
    assertEquals("projects/_/buckets/test-poc-bucket", meta.resource);
    assertEquals("global", meta.location);

    cache.remove("test-poc-bucket");
    org.junit.Assert.assertNull(cache.get("test-poc-bucket"));
  }
}
