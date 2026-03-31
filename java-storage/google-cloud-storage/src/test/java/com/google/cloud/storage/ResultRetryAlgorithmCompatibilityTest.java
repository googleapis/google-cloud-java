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

import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.junit.Test;

public final class ResultRetryAlgorithmCompatibilityTest {
  @Test
  public void validateDefaultStorageRetryStrategy_idempotent() {
    ResultRetryAlgorithm<?> idempotentHandler =
        StorageRetryStrategy.getDefaultStorageRetryStrategy().getIdempotentHandler();

    Set<Code> codes =
        GrpcToHttpStatusCodeTranslation.resultRetryAlgorithmToCodes(idempotentHandler);
    ImmutableSet<Code> expected =
        ImmutableSet.of(
            Code.INTERNAL, Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED, Code.DEADLINE_EXCEEDED);
    assertThat(codes).isEqualTo(expected);
  }
}
