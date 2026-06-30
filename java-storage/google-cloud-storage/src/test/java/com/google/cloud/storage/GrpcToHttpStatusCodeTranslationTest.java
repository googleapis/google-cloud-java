/*
 * Copyright 2022 Google LLC
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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status.Code;
import java.util.EnumMap;
import java.util.Set;
import org.junit.Test;

public final class GrpcToHttpStatusCodeTranslationTest {

  @Test
  public void grpcCodeToHttpStatusCode_expectedMapping() {
    EnumMap<Code, Integer> expected = new EnumMap<>(Code.class);
    expected.put(Code.OK, 200);
    expected.put(Code.INVALID_ARGUMENT, 400);
    expected.put(Code.OUT_OF_RANGE, 400);
    expected.put(Code.UNAUTHENTICATED, 401);
    expected.put(Code.PERMISSION_DENIED, 403);
    expected.put(Code.NOT_FOUND, 404);
    expected.put(Code.FAILED_PRECONDITION, 412);
    expected.put(Code.ALREADY_EXISTS, 409);
    expected.put(Code.RESOURCE_EXHAUSTED, 429);
    expected.put(Code.INTERNAL, 500);
    expected.put(Code.UNIMPLEMENTED, 501);
    expected.put(Code.UNAVAILABLE, 503);
    expected.put(Code.ABORTED, 409);
    expected.put(Code.CANCELLED, 0);
    expected.put(Code.UNKNOWN, 0);
    expected.put(Code.DEADLINE_EXCEEDED, 504);
    expected.put(Code.DATA_LOSS, 400);

    EnumMap<Code, Integer> actual = new EnumMap<>(Code.class);
    for (Code c : Code.values()) {
      actual.put(c, GrpcToHttpStatusCodeTranslation.grpcCodeToHttpStatusCode(c));
    }

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void resultRetryAlgorithmToCodes_idempotent() {
    StorageRetryStrategy strategy = StorageRetryStrategy.getDefaultStorageRetryStrategy();

    Set<StatusCode.Code> actual =
        GrpcToHttpStatusCodeTranslation.resultRetryAlgorithmToCodes(
            strategy.getIdempotentHandler());

    ImmutableSet<StatusCode.Code> expected =
        ImmutableSet.of(
            StatusCode.Code.UNAVAILABLE,
            StatusCode.Code.DEADLINE_EXCEEDED,
            StatusCode.Code.INTERNAL,
            StatusCode.Code.RESOURCE_EXHAUSTED);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void resultRetryAlgorithmToCodes_nonIdempotent() {
    StorageRetryStrategy strategy = StorageRetryStrategy.getDefaultStorageRetryStrategy();

    Set<StatusCode.Code> actual =
        GrpcToHttpStatusCodeTranslation.resultRetryAlgorithmToCodes(
            strategy.getNonidempotentHandler());

    assertThat(actual).isEqualTo(ImmutableSet.of());
  }
}
