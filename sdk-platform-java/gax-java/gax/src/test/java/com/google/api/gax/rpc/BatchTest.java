/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.rpc;

import static com.google.api.gax.rpc.testing.FakeBatchableApi.SQUARER_BATCHING_DESC;

import com.google.api.gax.batching.ElementCounter;
import com.google.api.gax.rpc.Batch.BatchByteCounter;
import com.google.api.gax.rpc.Batch.BatchElementCounter;
import com.google.api.gax.rpc.Batch.BatchMergerImpl;
import com.google.api.gax.rpc.testing.FakeBatchableApi;
import com.google.api.gax.rpc.testing.FakeBatchableApi.LabeledIntList;
import com.google.common.truth.Truth;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BatchTest {

  @Test
  void testConstructor() {
    LabeledIntList request = new LabeledIntList("lable", 2);
    Batch<LabeledIntList, List<Integer>> batch = createBatch(request);

    Truth.assertThat(batch.getRequest()).isEqualTo(request);
    Truth.assertThat(batch.getCallable()).isSameInstanceAs(batch.getCallable());
    Truth.assertThat(batch.getRequestIssuerList().size()).isEqualTo(1);
    Truth.assertThat(batch.getByteCount()).isEqualTo(2);
  }

  @Test
  void testMerge() {
    LabeledIntList request1 = new LabeledIntList("lable", 1);
    Batch<LabeledIntList, List<Integer>> batch1 = createBatch(request1);

    LabeledIntList request2 = new LabeledIntList("lable", 2);
    Batch<LabeledIntList, List<Integer>> batch2 = createBatch(request2);

    batch1.merge(batch2);

    Truth.assertThat(batch1.getByteCount()).isEqualTo(3);
  }

  @Test
  void testMergeStartEmpty() {
    LabeledIntList request1 = new LabeledIntList("lable", new ArrayList<Integer>());
    Batch<LabeledIntList, List<Integer>> batch1 = createBatch(request1, null);
    Truth.assertThat(batch1.getCallable()).isNull();

    LabeledIntList request2 = new LabeledIntList("lable", 2);
    Batch<LabeledIntList, List<Integer>> batch2 = createBatch(request2);

    batch1.merge(batch2);

    Truth.assertThat(batch1.getByteCount()).isEqualTo(2);
    Truth.assertThat(batch1.getCallable()).isNotNull();
    Truth.assertThat(batch1.getCallable()).isSameInstanceAs(batch2.getCallable());
  }

  @Test
  void testBatchElementCounter() {
    ElementCounter<Batch<LabeledIntList, List<Integer>>> counter =
        new BatchElementCounter<>(SQUARER_BATCHING_DESC);
    LabeledIntList request = new LabeledIntList("lable", 3);
    Batch<LabeledIntList, List<Integer>> batch = createBatch(request);

    Truth.assertThat(counter.count(batch)).isEqualTo(1);
  }

  @Test
  void testBatchByteCounter() {
    ElementCounter<Batch<LabeledIntList, List<Integer>>> counter = new BatchByteCounter<>();
    LabeledIntList request = new LabeledIntList("lable", 3);
    Batch<LabeledIntList, List<Integer>> batch = createBatch(request);

    Truth.assertThat(counter.count(batch)).isEqualTo(3);
  }

  @Test
  void testBatchMergerImpl() {
    LabeledIntList request1 = new LabeledIntList("lable", 1);
    Batch<LabeledIntList, List<Integer>> batch1 = createBatch(request1);

    LabeledIntList request2 = new LabeledIntList("lable", 2);
    Batch<LabeledIntList, List<Integer>> batch2 = createBatch(request2);

    BatchMergerImpl<LabeledIntList, List<Integer>> batchMerger = new BatchMergerImpl<>();
    batchMerger.merge(batch1, batch2);

    Truth.assertThat(batch1.getByteCount()).isEqualTo(3);
  }

  private Batch<LabeledIntList, List<Integer>> createBatch(LabeledIntList request) {
    @SuppressWarnings("unchecked")
    UnaryCallable<FakeBatchableApi.LabeledIntList, List<Integer>> callable =
        Mockito.mock(UnaryCallable.class);
    return createBatch(request, callable);
  }

  private Batch<LabeledIntList, List<Integer>> createBatch(
      LabeledIntList request,
      UnaryCallable<FakeBatchableApi.LabeledIntList, List<Integer>> callable) {
    BatchingDescriptor<LabeledIntList, List<Integer>> batchingDescriptor = SQUARER_BATCHING_DESC;
    BatchedFuture<List<Integer>> batchedFuture = new BatchedFuture<>();

    return new Batch<>(batchingDescriptor, request, callable, batchedFuture);
  }
}
