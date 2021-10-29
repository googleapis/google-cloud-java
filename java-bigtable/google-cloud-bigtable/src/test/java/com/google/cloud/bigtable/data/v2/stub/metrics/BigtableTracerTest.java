/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracer.Scope;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class BigtableTracerTest {
  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock private ApiTracer child1;
  @Mock private ApiTracer child2;

  private BigtableTracer bigtableTracer;

  @Before
  public void setup() {
    bigtableTracer = new BigtableTracer(ImmutableList.of(child1, child2));
  }

  @Test
  public void testInScope() {
    Scope scope1 = mock(Scope.class);
    when(child1.inScope()).thenReturn(scope1);

    Scope scope2 = mock(Scope.class);
    when(child2.inScope()).thenReturn(scope2);

    Scope parentScope = bigtableTracer.inScope();

    parentScope.close();
    verify(scope1, times(1)).close();
  }

  @Test
  public void testOperationSucceeded() {
    bigtableTracer.operationSucceeded();
    verify(child1, times(1)).operationSucceeded();
    verify(child2, times(1)).operationSucceeded();
  }

  @Test
  public void testOperationCancelled() {
    bigtableTracer.operationCancelled();
    verify(child1, times(1)).operationCancelled();
    verify(child2, times(1)).operationCancelled();
  }

  @Test
  public void testOperationFailed() {
    RuntimeException error = new RuntimeException();
    bigtableTracer.operationFailed(error);
    verify(child1, times(1)).operationFailed(error);
    verify(child2, times(1)).operationFailed(error);
  }

  @Test
  public void testConnectionSelected() {
    bigtableTracer.connectionSelected("connection-one");
    verify(child1, times(1)).connectionSelected("connection-one");
    verify(child2, times(1)).connectionSelected("connection-one");
  }

  @Test
  public void testAttemptStarted() {
    bigtableTracer.attemptStarted(3);
    verify(child1, times(1)).attemptStarted(3);
    verify(child2, times(1)).attemptStarted(3);
  }

  @Test
  public void testAttemptSucceeded() {
    bigtableTracer.attemptSucceeded();
    verify(child1, times(1)).attemptSucceeded();
    verify(child2, times(1)).attemptSucceeded();
  }

  @Test
  public void testAttemptCancelled() {
    bigtableTracer.attemptCancelled();
    verify(child1, times(1)).attemptCancelled();
    verify(child2, times(1)).attemptCancelled();
  }

  @Test
  public void testAttemptFailed() {
    RuntimeException error = new RuntimeException();
    Duration delay = Duration.ofMillis(10);
    bigtableTracer.attemptFailed(error, delay);
    verify(child1, times(1)).attemptFailed(error, delay);
    verify(child2, times(1)).attemptFailed(error, delay);
  }

  @Test
  public void testAttemptFailedRetriesExhausted() {
    RuntimeException error = new RuntimeException();
    bigtableTracer.attemptFailedRetriesExhausted(error);
    verify(child1, times(1)).attemptFailedRetriesExhausted(error);
    verify(child2, times(1)).attemptFailedRetriesExhausted(error);
  }

  @Test
  public void testAttemptPermanentFailure() {
    RuntimeException error = new RuntimeException();
    bigtableTracer.attemptPermanentFailure(error);
    verify(child1, times(1)).attemptPermanentFailure(error);
    verify(child2, times(1)).attemptPermanentFailure(error);
  }

  @Test
  public void testLroStartFailed() {
    RuntimeException error = new RuntimeException();
    bigtableTracer.lroStartFailed(error);
    verify(child1, times(1)).lroStartFailed(error);
    verify(child2, times(1)).lroStartFailed(error);
  }

  @Test
  public void testLroStartSucceeded() {
    bigtableTracer.lroStartSucceeded();
    verify(child1, times(1)).lroStartSucceeded();
    verify(child2, times(1)).lroStartSucceeded();
  }

  @Test
  public void testResponseReceived() {
    bigtableTracer.responseReceived();
    verify(child1, times(1)).responseReceived();
    verify(child2, times(1)).responseReceived();
  }

  @Test
  public void testRequestSent() {
    bigtableTracer.requestSent();
    verify(child1, times(1)).requestSent();
    verify(child2, times(1)).requestSent();
  }

  @Test
  public void testBatchRequestSent() {
    bigtableTracer.batchRequestSent(2, 20);
    verify(child1, times(1)).batchRequestSent(2, 20);
    verify(child2, times(1)).batchRequestSent(2, 20);
  }
}
