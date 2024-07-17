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
package com.google.cloud.bigtable.data.v2.stub.sql;

import static com.google.common.truth.Truth.assertAbout;

import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.google.common.truth.Truth;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;

/** Truth subject for {@link ProtoRowsMergingStateMachine}. Intended for ease-of-use in testing. */
public final class ProtoRowsMergingStateMachineSubject extends Subject {

  private final ProtoRowsMergingStateMachine actual;

  private ProtoRowsMergingStateMachineSubject(
      FailureMetadata metadata, @Nullable ProtoRowsMergingStateMachine actual) {
    super(metadata, actual);
    this.actual = actual;
  }

  public static Factory<ProtoRowsMergingStateMachineSubject, ProtoRowsMergingStateMachine>
      stateMachine() {
    return ProtoRowsMergingStateMachineSubject::new;
  }

  public static ProtoRowsMergingStateMachineSubject assertThat(
      @Nullable ProtoRowsMergingStateMachine actual) {
    return assertAbout(stateMachine()).that(actual);
  }

  public void hasCompleteBatch(boolean expectation) {
    if (expectation) {
      check("hasCompleteBatch()").that(actual.hasCompleteBatch()).isTrue();
    } else {
      check("hasCompleteBatch()").that(actual.hasCompleteBatch()).isFalse();
    }
  }

  public void isBatchInProgress(boolean expectation) {
    if (expectation) {
      check("isBatchInProgress()").that(actual.isBatchInProgress()).isTrue();
    } else {
      check("isBatchInProgress()").that(actual.isBatchInProgress()).isFalse();
    }
  }

  public void populateQueueYields(SqlRow... expectedRows) {
    Queue<SqlRow> actualQueue = new ArrayDeque<>();
    actual.populateQueue(actualQueue);
    Truth.assertThat(actualQueue).containsExactlyElementsIn(expectedRows);
  }
}
