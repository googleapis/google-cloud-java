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

package com.google.cloud.spanner.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.rpc.Status;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import com.google.spanner.v1.Mutation;
import com.google.spanner.v1.RequestOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link BatchWriteResumptionState}. */
@RunWith(JUnit4.class)
public class BatchWriteResumptionStateTest {

  private static final Status STATUS_OK =
      Status.newBuilder().setCode(com.google.rpc.Code.OK_VALUE).build();
  private static final Status STATUS_ABORTED =
      Status.newBuilder().setCode(com.google.rpc.Code.ABORTED_VALUE).build();

  private static BatchWriteRequest.MutationGroup groupWithKey(String key) {
    return BatchWriteRequest.MutationGroup.newBuilder()
        .addMutations(
            Mutation.newBuilder()
                .setInsert(
                    Mutation.Write.newBuilder()
                        .setTable("T")
                        .addColumns("K")
                        .addValues(
                            ListValue.newBuilder()
                                .addValues(Value.newBuilder().setStringValue(key).build())
                                .build())
                        .build())
                .build())
        .build();
  }

  private static BatchWriteRequest requestWithGroups(String... keys) {
    BatchWriteRequest.Builder builder =
        BatchWriteRequest.newBuilder()
            .setSession("projects/p/instances/i/databases/d/sessions/s1")
            .setRequestOptions(RequestOptions.newBuilder().setTransactionTag("tag-1").build())
            .setExcludeTxnFromChangeStreams(true);
    for (String key : keys) {
      builder.addMutationGroups(groupWithKey(key));
    }
    return builder.build();
  }

  @Test
  public void emptyRequestIsImmediatelyAcknowledged() {
    BatchWriteResumptionState state = new BatchWriteResumptionState(requestWithGroups());
    assertTrue(state.isAllAcknowledged());
    assertEquals(0, state.getRemainingCount());
    assertEquals(0, state.getTotalCount());
    assertEquals(0, state.getRequestTemplate().getMutationGroupsCount());
  }

  @Test
  public void translatesIndexesAcrossMultipleCompactedAttemptsAndPreservesRequestMetadata() {
    BatchWriteRequest initial = requestWithGroups("g0", "g1", "g2", "g3", "g4");
    BatchWriteResumptionState state = new BatchWriteResumptionState(initial);

    // Attempt 0: all 5 groups [0, 1, 2, 3, 4]
    BatchWriteRequest attempt0 = state.buildNextAttemptRequest();
    assertEquals(5, attempt0.getMutationGroupsCount());
    assertEquals("tag-1", attempt0.getRequestOptions().getTransactionTag());
    assertTrue(attempt0.getExcludeTxnFromChangeStreams());

    // Acknowledge relative 1 (orig 1) with OK and relative 3 (orig 3) with non-OK ABORTED.
    // On the initial full-batch attempt, response is returned directly without copying.
    BatchWriteResponse rawResp0 =
        BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(1).build();
    BatchWriteResponse resp0 = state.translateAndAcknowledge(rawResp0);
    assertSame(rawResp0, resp0);
    assertThat(resp0.getIndexesList()).containsExactly(1);
    BatchWriteResponse resp1 =
        state.translateAndAcknowledge(
            BatchWriteResponse.newBuilder().setStatus(STATUS_ABORTED).addIndexes(3).build());
    assertThat(resp1.getIndexesList()).containsExactly(3);
    assertEquals(3, state.getRemainingCount());
    assertFalse(state.isAllAcknowledged());

    // Attempt 1: compacted to remaining [g0 -> 0, g2 -> 1, g4 -> 2]
    BatchWriteRequest attempt1 = state.buildNextAttemptRequest();
    assertEquals(3, attempt1.getMutationGroupsCount());
    assertEquals(groupWithKey("g0"), attempt1.getMutationGroups(0));
    assertEquals(groupWithKey("g2"), attempt1.getMutationGroups(1));
    assertEquals(groupWithKey("g4"), attempt1.getMutationGroups(2));
    assertEquals("tag-1", attempt1.getRequestOptions().getTransactionTag());
    assertTrue(attempt1.getExcludeTxnFromChangeStreams());

    // Acknowledge relative [2, 0] -> original [4, 0]
    BatchWriteResponse resp2 =
        state.translateAndAcknowledge(
            BatchWriteResponse.newBuilder()
                .setStatus(STATUS_OK)
                .addIndexes(2)
                .addIndexes(0)
                .build());
    assertThat(resp2.getIndexesList()).containsExactly(4, 0).inOrder();
    assertEquals(1, state.getRemainingCount());

    // Attempt 2: compacted to [g2 -> 0]
    BatchWriteRequest attempt2 = state.buildNextAttemptRequest();
    assertEquals(1, attempt2.getMutationGroupsCount());
    assertEquals(groupWithKey("g2"), attempt2.getMutationGroups(0));

    BatchWriteResponse resp3 =
        state.translateAndAcknowledge(
            BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(0).build());
    assertThat(resp3.getIndexesList()).containsExactly(2);
    assertTrue(state.isAllAcknowledged());
    assertEquals(0, state.getRemainingCount());
  }

  @Test
  public void duplicateIndexesAreTranslatedAndDecrementedOnlyOnce() {
    BatchWriteResumptionState state = new BatchWriteResumptionState(requestWithGroups("g0", "g1"));
    state.buildNextAttemptRequest();

    BatchWriteResponse resp =
        state.translateAndAcknowledge(
            BatchWriteResponse.newBuilder()
                .setStatus(STATUS_OK)
                .addIndexes(0)
                .addIndexes(0)
                .build());
    assertThat(resp.getIndexesList()).containsExactly(0, 0);
    assertEquals(1, state.getRemainingCount());
    assertFalse(state.isAllAcknowledged());
  }

  @Test
  public void translateAndAcknowledgeBeforeBuildNextAttemptRequestThrowsIllegalState() {
    BatchWriteResumptionState state = new BatchWriteResumptionState(requestWithGroups("g0"));
    assertThrows(
        IllegalStateException.class,
        () ->
            state.translateAndAcknowledge(
                BatchWriteResponse.newBuilder().setStatus(STATUS_OK).build()));
  }

  @Test
  public void outOfBoundsIndexThrowsNonRetryableInternalWithoutMutatingState() {
    BatchWriteResumptionState state = new BatchWriteResumptionState(requestWithGroups("g0", "g1"));
    state.buildNextAttemptRequest();

    // Mixed valid index 0 + invalid index 2 must leave tracking state unmodified.
    ApiException highEx =
        assertThrows(
            ApiException.class,
            () ->
                state.translateAndAcknowledge(
                    BatchWriteResponse.newBuilder()
                        .setStatus(STATUS_OK)
                        .addIndexes(0)
                        .addIndexes(2)
                        .build()));
    assertEquals(Code.INTERNAL, highEx.getStatusCode().getCode());
    assertFalse(highEx.isRetryable());
    assertEquals(2, state.getRemainingCount());

    // Negative index also rejected atomically.
    ApiException negEx =
        assertThrows(
            ApiException.class,
            () ->
                state.translateAndAcknowledge(
                    BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(-1).build()));
    assertEquals(Code.INTERNAL, negEx.getStatusCode().getCode());
    assertFalse(negEx.isRetryable());
    assertEquals(2, state.getRemainingCount());
  }

  @Test
  public void requestTemplateAndPendingSlotClearAcknowledgedPayloads() {
    BatchWriteRequest.MutationGroup group0 = groupWithKey("payload-0");
    BatchWriteRequest.MutationGroup group1 = groupWithKey("payload-1");
    BatchWriteRequest initial =
        BatchWriteRequest.newBuilder()
            .setSession("projects/p/instances/i/databases/d/sessions/s1")
            .addMutationGroups(group0)
            .addMutationGroups(group1)
            .build();
    BatchWriteResumptionState state = new BatchWriteResumptionState(initial);

    // Request template must not retain any mutation group payloads.
    assertEquals(0, state.getRequestTemplate().getMutationGroupsCount());
    assertSame(group0, state.getPending(0));
    assertSame(group1, state.getPending(1));

    state.buildNextAttemptRequest();
    state.translateAndAcknowledge(
        BatchWriteResponse.newBuilder().setStatus(STATUS_OK).addIndexes(0).build());

    // Acknowledged slot must be nulled out while unacknowledged group remains intact.
    assertNull(state.getPending(0));
    assertNotNull(state.getPending(1));
    assertSame(group1, state.getPending(1));
    assertEquals(1, state.getRemainingCount());

    BatchWriteRequest retryRequest = state.buildNextAttemptRequest();
    assertEquals(1, retryRequest.getMutationGroupsCount());
    assertEquals(group1, retryRequest.getMutationGroups(0));
  }
}
