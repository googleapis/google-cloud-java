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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class OtelStorageDecoratorAcoUnitTest {

  static {
    OtelStorageDecorator.acoEnabled = true;
  }

  private OpenTelemetry mockOtel;

  @Before
  public void setUp() {
    mockOtel = mock(OpenTelemetry.class);
    Tracer mockTracer = mock(Tracer.class);
    SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
    Span mockSpan = mock(Span.class);

    Mockito.when(mockOtel.getTracer(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(mockTracer);
    Mockito.when(mockTracer.spanBuilder(Mockito.anyString())).thenReturn(mockSpanBuilder);
    Mockito.when(mockSpanBuilder.setAllAttributes(Mockito.any())).thenReturn(mockSpanBuilder);
    Mockito.when(mockSpanBuilder.startSpan()).thenReturn(mockSpan);
  }

  @Test
  public void testAcoSuccessFlow() throws Exception {
    Storage mockStorage = mock(Storage.class);
    Bucket mockBucket = mock(Bucket.class);

    Mockito.when(
            mockStorage.get(
                Mockito.eq("success-bucket"), Mockito.any(Storage.BucketGetOption[].class)))
        .thenReturn(mockBucket);
    Mockito.when(mockBucket.getProject()).thenReturn(BigInteger.valueOf(12345));
    Mockito.when(mockBucket.getLocation()).thenReturn("us-east1");
    Mockito.when(mockBucket.getLocationType()).thenReturn("region");

    try (Storage decoratedStorage =
        OtelStorageDecorator.decorate(
            mockStorage, mockOtel, TransportCompatibility.Transport.HTTP)) {
      OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;

      AcoSpanBuilder.checkCacheAndTriggerFetch(
          osd.delegate,
          osd.acoContext.getCache(),
          osd.acoContext.getCacheExecutor(),
          "success-bucket");

      // Wait for background task to finish cleanly
      osd.acoContext.getCacheExecutor().shutdown();
      osd.acoContext.getCacheExecutor().awaitTermination(5, TimeUnit.SECONDS);

      BucketMetadataCache.BucketMetadata meta = osd.acoContext.getCache().get("success-bucket");
      assertNotNull(meta);
      assertEquals("projects/12345/buckets/success-bucket", meta.resource);
      assertEquals("us-east1", meta.location);
      assertFalse(meta.fetchPending);
    }
  }

  @Test
  public void testAco404NotFoundFlowWithException() throws Exception {
    Storage mockStorage = mock(Storage.class);
    StorageException ex = new StorageException(404, "Bucket not found");
    Mockito.when(
            mockStorage.get(
                Mockito.eq("nonexistent-bucket"), Mockito.any(Storage.BucketGetOption[].class)))
        .thenThrow(ex);

    try (Storage decoratedStorage =
        OtelStorageDecorator.decorate(
            mockStorage, mockOtel, TransportCompatibility.Transport.HTTP)) {
      OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;

      AcoSpanBuilder.checkCacheAndTriggerFetch(
          osd.delegate,
          osd.acoContext.getCache(),
          osd.acoContext.getCacheExecutor(),
          "nonexistent-bucket");

      // Wait for background task to finish
      osd.acoContext.getCacheExecutor().shutdown();
      osd.acoContext.getCacheExecutor().awaitTermination(5, TimeUnit.SECONDS);

      // Verified not found -> Entry must be cleanly evicted (null)
      BucketMetadataCache.BucketMetadata meta = osd.acoContext.getCache().get("nonexistent-bucket");
      assertNull(meta);
    }
  }

  @Test
  public void testAco404NotFoundFlowWithNull() throws Exception {
    Storage mockStorage = mock(Storage.class);
    Mockito.when(
            mockStorage.get(
                Mockito.eq("nonexistent-bucket"), Mockito.any(Storage.BucketGetOption[].class)))
        .thenReturn(null);

    try (Storage decoratedStorage =
        OtelStorageDecorator.decorate(
            mockStorage, mockOtel, TransportCompatibility.Transport.HTTP)) {
      OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;

      AcoSpanBuilder.checkCacheAndTriggerFetch(
          osd.delegate,
          osd.acoContext.getCache(),
          osd.acoContext.getCacheExecutor(),
          "nonexistent-bucket");

      // Wait for background task to finish
      osd.acoContext.getCacheExecutor().shutdown();
      osd.acoContext.getCacheExecutor().awaitTermination(5, TimeUnit.SECONDS);

      // Verified not found -> Entry must be cleanly evicted (null)
      BucketMetadataCache.BucketMetadata meta = osd.acoContext.getCache().get("nonexistent-bucket");
      assertNull(meta);
    }
  }

  @Test
  public void testAco403ForbiddenFlow() throws Exception {
    Storage mockStorage = mock(Storage.class);
    StorageException ex = new StorageException(403, "Access Denied");
    Mockito.when(
            mockStorage.get(
                Mockito.eq("forbidden-bucket"), Mockito.any(Storage.BucketGetOption[].class)))
        .thenThrow(ex);

    try (Storage decoratedStorage =
        OtelStorageDecorator.decorate(
            mockStorage, mockOtel, TransportCompatibility.Transport.HTTP)) {
      OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;

      AcoSpanBuilder.checkCacheAndTriggerFetch(
          osd.delegate,
          osd.acoContext.getCache(),
          osd.acoContext.getCacheExecutor(),
          "forbidden-bucket");

      // Wait for background task to finish
      osd.acoContext.getCacheExecutor().shutdown();
      osd.acoContext.getCacheExecutor().awaitTermination(5, TimeUnit.SECONDS);

      // Forbidden -> Fallback values retained with pending = false (Do Not Retry)
      BucketMetadataCache.BucketMetadata meta = osd.acoContext.getCache().get("forbidden-bucket");
      assertNotNull(meta);
      assertEquals("projects/_/buckets/forbidden-bucket", meta.resource);
      assertEquals("global", meta.location);
      assertFalse(meta.fetchPending);
    }
  }

  @Test
  public void testAcoThunderingHerdProtection() throws Exception {
    Storage mockStorage = mock(Storage.class);
    Mockito.when(
            mockStorage.get(
                Mockito.eq("concurrent-bucket"), Mockito.any(Storage.BucketGetOption[].class)))
        .thenAnswer(
            invocation -> {
              Thread.sleep(100);
              return null;
            });

    try (Storage decoratedStorage =
        OtelStorageDecorator.decorate(
            mockStorage, mockOtel, TransportCompatibility.Transport.HTTP)) {
      OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;

      // Trigger twice concurrently
      AcoSpanBuilder.checkCacheAndTriggerFetch(
          osd.delegate,
          osd.acoContext.getCache(),
          osd.acoContext.getCacheExecutor(),
          "concurrent-bucket");
      AcoSpanBuilder.checkCacheAndTriggerFetch(
          osd.delegate,
          osd.acoContext.getCache(),
          osd.acoContext.getCacheExecutor(),
          "concurrent-bucket");

      // Wait for background tasks
      osd.acoContext.getCacheExecutor().shutdown();
      osd.acoContext.getCacheExecutor().awaitTermination(5, TimeUnit.SECONDS);

      // Verify get was called exactly once (no duplicate fetches)
      Mockito.verify(mockStorage, Mockito.times(1))
          .get(Mockito.eq("concurrent-bucket"), Mockito.any(Storage.BucketGetOption[].class));
    }
  }

  @Test
  public void testAcoAcoSpanEndSkipsPending() throws Exception {
    Storage mockStorage = mock(Storage.class);
    try (Storage decoratedStorage =
        OtelStorageDecorator.decorate(
            mockStorage, mockOtel, TransportCompatibility.Transport.HTTP)) {
      OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;

      // Manually put a pending placeholder entry
      osd.acoContext
          .getCache()
          .put("pending-bucket", "projects/_/buckets/pending-bucket", "global", true);

      Span mockSpan = mock(Span.class);
      AcoSpan acoSpan = new AcoSpan(mockSpan, "pending-bucket", osd);

      // Call end() while pending
      acoSpan.end();

      // Verify OTel span setAttribute was never called since cache entry was pending
      Mockito.verify(mockSpan, Mockito.never())
          .setAttribute(Mockito.anyString(), Mockito.anyString());
    }
  }

  @Test
  public void testAcoAcoSpanEndAppliesResolved() throws Exception {
    Storage mockStorage = mock(Storage.class);
    try (Storage decoratedStorage =
        OtelStorageDecorator.decorate(
            mockStorage, mockOtel, TransportCompatibility.Transport.HTTP)) {
      OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;

      // Manually put a resolved non-pending entry
      osd.acoContext
          .getCache()
          .put("resolved-bucket", "projects/123/buckets/resolved-bucket", "us-east1", false);

      Span mockSpan = mock(Span.class);
      AcoSpan acoSpan = new AcoSpan(mockSpan, "resolved-bucket", osd);

      acoSpan.end();

      // Verify OTel span attributes were set successfully
      Mockito.verify(mockSpan)
          .setAttribute("gcp.resource.destination.id", "projects/123/buckets/resolved-bucket");
      Mockito.verify(mockSpan).setAttribute("gcp.resource.destination.location", "us-east1");
    }
  }

  @Test
  public void testDisabledAcoBehavior() throws Exception {
    OtelStorageDecorator.acoEnabled = false;
    try {
      Storage mockStorage = mock(Storage.class);
      try (Storage decoratedStorage =
          OtelStorageDecorator.decorate(
              mockStorage, mockOtel, TransportCompatibility.Transport.HTTP)) {
        OtelStorageDecorator osd = (OtelStorageDecorator) decoratedStorage;

        // Verify acoContext is a DisabledAcoContext
        assertNotNull(osd.acoContext);
        assertNull(osd.acoContext.getCache());
        assertNull(osd.acoContext.getCacheExecutor());

        // Verify that span builder wrapping behaves as a no-op
        SpanBuilder mockSpanBuilder = mock(SpanBuilder.class);
        SpanBuilder wrapped = osd.acoContext.wrap(mockSpanBuilder, osd);
        assertEquals(mockSpanBuilder, wrapped); // Should return the exact same instance, unwrapped
      }
    } finally {
      OtelStorageDecorator.acoEnabled = true;
    }
  }
}
