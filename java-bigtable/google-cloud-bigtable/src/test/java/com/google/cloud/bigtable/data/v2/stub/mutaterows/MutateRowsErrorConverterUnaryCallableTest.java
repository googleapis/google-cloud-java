/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException.FailedMutation;
import com.google.cloud.bigtable.data.v2.stub.MutateRowsErrorConverterUnaryCallable;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class MutateRowsErrorConverterUnaryCallableTest {
  @Mock private UnaryCallable<BulkMutation, MutateRowsAttemptResult> innerCallable;
  @Captor private ArgumentCaptor<BulkMutation> innerMutation;
  private SettableApiFuture<MutateRowsAttemptResult> innerResult;

  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  @Before
  public void setUp() {
    innerResult = SettableApiFuture.create();
    Mockito.when(innerCallable.futureCall(innerMutation.capture(), Mockito.any()))
        .thenReturn(innerResult);
  }

  @Test
  public void testSuccess() {
    MutateRowsErrorConverterUnaryCallable callable =
        new MutateRowsErrorConverterUnaryCallable(innerCallable);

    innerResult.set(MutateRowsAttemptResult.success());

    Throwable unexpectedError = null;
    try {
      callable.call(BulkMutation.create("fake-table"));
    } catch (Throwable t) {
      unexpectedError = t;
    }
    assertThat(unexpectedError).isNull();
  }

  @Test
  public void testPartialFailure() {
    MutateRowsErrorConverterUnaryCallable callable =
        new MutateRowsErrorConverterUnaryCallable(innerCallable);

    innerResult.set(
        MutateRowsAttemptResult.create(
            Arrays.asList(
                FailedMutation.create(
                    0,
                    ApiExceptionFactory.createException(
                        null, GrpcStatusCode.of(io.grpc.Status.Code.INTERNAL), false))),
            true));

    MutateRowsException exception =
        Assert.assertThrows(
            MutateRowsException.class, () -> callable.call(BulkMutation.create("fake-table")));

    assertThat(exception).isInstanceOf(MutateRowsException.class);
    assertThat((exception).isRetryable()).isTrue();
  }

  @Test
  public void testRPCFailure() {
    MutateRowsErrorConverterUnaryCallable callable =
        new MutateRowsErrorConverterUnaryCallable(innerCallable);

    innerResult.setException(new Exception("RPC error"));

    Exception exception =
        Assert.assertThrows(
            Exception.class, () -> callable.call(BulkMutation.create("fake-table")));

    assertThat(exception).isInstanceOf(Exception.class);
  }
}
