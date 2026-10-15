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

package com.google.cloud.spanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TransactionRoutingTest {

  private SpannerRpc rpc;
  private SessionImpl session;
  private SessionReference sessionReference;
  private SpannerImpl spanner;
  private SpannerOptions spannerOptions;

  @Before
  public void setUp() {
    rpc = mock(SpannerRpc.class);
    session = mock(SessionImpl.class);
    sessionReference = mock(SessionReference.class);
    spanner = mock(SpannerImpl.class);
    spannerOptions = mock(SpannerOptions.class);

    when(session.getSessionReference()).thenReturn(sessionReference);
    when(session.getSpanner()).thenReturn(spanner);
    when(spanner.getOptions()).thenReturn(spannerOptions);

    // Default: system-level unspecified (Tier 4 fallback)
    setClientDefaultOptions(
        IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED, ReadLockMode.READ_LOCK_MODE_UNSPECIFIED);

    TraceWrapper tracer = mock(TraceWrapper.class);
    ISpan span = mock(ISpan.class);
    when(session.getTracer()).thenReturn(tracer);
    when(tracer.getCurrentSpan()).thenReturn(span);
  }

  private void setClientDefaultOptions(IsolationLevel iso, ReadLockMode lock) {
    TransactionOptions defaultTxnOptions =
        TransactionOptions.newBuilder()
            .setIsolationLevel(iso)
            .setReadWrite(TransactionOptions.ReadWrite.newBuilder().setReadLockMode(lock))
            .build();
    when(spannerOptions.getDefaultTransactionOptions()).thenReturn(defaultTxnOptions);
  }

  private TransactionContextImpl createContext(Options options) {
    return TransactionContextImpl.newBuilder()
        .setSession(session)
        .setTransactionId(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
        .setOptions(options)
        .setRpc(rpc)
        .setTracer(session.getTracer())
        .setSpan(session.getTracer().getCurrentSpan())
        .build();
  }

  @Test
  public void testPrecedenceTier4SystemDefaults() {
    // Tier 4: Unspecified everywhere should fall back to SERIALIZABLE / PESSIMISTIC,
    // routeToLeader=true.
    TransactionContextImpl context = createContext(Options.fromTransactionOptions());
    assertTrue(context.isRouteToLeader());
  }

  @Test
  public void testPrecedenceTier3DatabaseDefaultsRepeatableRead() {
    // Tier 3: Database Defaults sets REPEATABLE_READ + OPTIMISTIC, routeToLeader=false.
    DatabaseMetadata dbMetadata =
        new DatabaseMetadata(
            Dialect.GOOGLE_STANDARD_SQL, IsolationLevel.REPEATABLE_READ, ReadLockMode.OPTIMISTIC);
    when(sessionReference.getDatabaseMetadata()).thenReturn(dbMetadata);

    TransactionContextImpl context = createContext(Options.fromTransactionOptions());
    assertFalse(context.isRouteToLeader());
  }

  @Test
  public void testPrecedenceTier3DatabaseDefaultsRepeatableReadUnspecifiedLock() {
    // Tier 3: Database Defaults sets REPEATABLE_READ + unspecified lock, routeToLeader=false.
    DatabaseMetadata dbMetadata =
        new DatabaseMetadata(
            Dialect.GOOGLE_STANDARD_SQL,
            IsolationLevel.REPEATABLE_READ,
            ReadLockMode.READ_LOCK_MODE_UNSPECIFIED);
    when(sessionReference.getDatabaseMetadata()).thenReturn(dbMetadata);

    TransactionContextImpl context = createContext(Options.fromTransactionOptions());
    assertFalse(context.isRouteToLeader());
  }

  @Test
  public void testPrecedenceTier3DatabaseDefaultsSerializable() {
    // Tier 3: Database Defaults sets SERIALIZABLE + PESSIMISTIC, routeToLeader=true.
    DatabaseMetadata dbMetadata =
        new DatabaseMetadata(
            Dialect.GOOGLE_STANDARD_SQL, IsolationLevel.SERIALIZABLE, ReadLockMode.PESSIMISTIC);
    when(sessionReference.getDatabaseMetadata()).thenReturn(dbMetadata);

    TransactionContextImpl context = createContext(Options.fromTransactionOptions());
    assertTrue(context.isRouteToLeader());
  }

  @Test
  public void testPrecedenceTier2ClientStaticOverridesDatabase() {
    // Tier 2: Client-Side Static config is REPEATABLE_READ + OPTIMISTIC.
    // Database Defaults has SERIALIZABLE + PESSIMISTIC.
    // routeToLeader=false because Tier 2 overrides Tier 3.
    setClientDefaultOptions(IsolationLevel.REPEATABLE_READ, ReadLockMode.OPTIMISTIC);

    DatabaseMetadata dbMetadata =
        new DatabaseMetadata(
            Dialect.GOOGLE_STANDARD_SQL, IsolationLevel.SERIALIZABLE, ReadLockMode.PESSIMISTIC);
    when(sessionReference.getDatabaseMetadata()).thenReturn(dbMetadata);

    TransactionContextImpl context = createContext(Options.fromTransactionOptions());
    assertFalse(context.isRouteToLeader());
  }

  @Test
  public void testPrecedenceTier1CallSiteOverridesAll() {
    // Tier 1: Call-site options explicitly set REPEATABLE_READ + OPTIMISTIC.
    // Client-Side Static has SERIALIZABLE + PESSIMISTIC.
    // Database Defaults has SERIALIZABLE + PESSIMISTIC.
    // routeToLeader=false because Tier 1 overrides everything.
    setClientDefaultOptions(IsolationLevel.SERIALIZABLE, ReadLockMode.PESSIMISTIC);

    DatabaseMetadata dbMetadata =
        new DatabaseMetadata(
            Dialect.GOOGLE_STANDARD_SQL, IsolationLevel.SERIALIZABLE, ReadLockMode.PESSIMISTIC);
    when(sessionReference.getDatabaseMetadata()).thenReturn(dbMetadata);

    Options callSiteOptions =
        Options.fromTransactionOptions(
            Options.isolationLevel(IsolationLevel.REPEATABLE_READ),
            Options.readLockMode(ReadLockMode.OPTIMISTIC));

    TransactionContextImpl context = createContext(callSiteOptions);
    assertFalse(context.isRouteToLeader());
  }

  @Test
  public void testPrecedenceTier1CallSiteSerializableOverridesAll() {
    // Tier 1: Call-site options explicitly set SERIALIZABLE + PESSIMISTIC.
    // Client-Side Static has REPEATABLE_READ + OPTIMISTIC.
    // Database Defaults has REPEATABLE_READ + OPTIMISTIC.
    // routeToLeader=true because Tier 1 overrides everything.
    setClientDefaultOptions(IsolationLevel.REPEATABLE_READ, ReadLockMode.OPTIMISTIC);

    DatabaseMetadata dbMetadata =
        new DatabaseMetadata(
            Dialect.GOOGLE_STANDARD_SQL, IsolationLevel.REPEATABLE_READ, ReadLockMode.OPTIMISTIC);
    when(sessionReference.getDatabaseMetadata()).thenReturn(dbMetadata);

    Options callSiteOptions =
        Options.fromTransactionOptions(
            Options.isolationLevel(IsolationLevel.SERIALIZABLE),
            Options.readLockMode(ReadLockMode.PESSIMISTIC));

    TransactionContextImpl context = createContext(callSiteOptions);
    assertTrue(context.isRouteToLeader());
  }

  @Test
  public void testRepeatableReadWithNullLockModeCanEnableLRYW() {
    when(sessionReference.getDatabaseMetadata()).thenReturn(null);
    Options callSiteOptions =
        Options.fromTransactionOptions(Options.isolationLevel(IsolationLevel.REPEATABLE_READ));
    TransactionContextImpl context = createContext(callSiteOptions);
    assertFalse(context.isRouteToLeader());
  }
}
