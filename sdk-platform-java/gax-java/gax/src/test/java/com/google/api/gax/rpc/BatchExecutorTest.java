/*
 * Copyright 2016 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

class BatchExecutorTest {

  BatchingDescriptor<List<Integer>, Integer> integerDescriptor =
      new BatchingDescriptor<List<Integer>, Integer>() {

        @Override
        public PartitionKey getBatchPartitionKey(List<Integer> request) {
          return new PartitionKey(request.get(0) % 2);
        }

        @Override
        public RequestBuilder<List<Integer>> getRequestBuilder() {
          return new RequestBuilder<List<Integer>>() {

            List<Integer> list = new ArrayList<>();

            @Override
            public void appendRequest(List<Integer> request) {
              list.addAll(request);
            }

            @Override
            public List<Integer> build() {
              return list;
            }
          };
        }

        @Override
        public void splitResponse(
            Integer batchResponse, Collection<? extends BatchedRequestIssuer<Integer>> batch) {}

        @Override
        public void splitException(
            Throwable throwable, Collection<? extends BatchedRequestIssuer<Integer>> batch) {}

        @Override
        public long countElements(List<Integer> request) {
          return request.size();
        }

        @Override
        public long countBytes(List<Integer> request) {
          return request.size();
        }
      };

  @Test
  void testValidate() {
    BatchExecutor<List<Integer>, Integer> executor =
        new BatchExecutor<List<Integer>, Integer>(integerDescriptor, new PartitionKey(0));
    List<Integer> request = new ArrayList<Integer>();
    request.add(2);
    Batch<List<Integer>, Integer> batchingContextOk =
        new Batch<>(integerDescriptor, request, null, null);
    executor.validateBatch(batchingContextOk);
  }

  @Test
  void testValidateFailure() {
    BatchExecutor<List<Integer>, Integer> executor =
        new BatchExecutor<List<Integer>, Integer>(integerDescriptor, new PartitionKey(0));
    List<Integer> request = new ArrayList<>();
    request.add(3);
    Batch<List<Integer>, Integer> batchingContextOk =
        new Batch<>(integerDescriptor, request, null, null);
    assertThrows(IllegalArgumentException.class, () -> executor.validateBatch(batchingContextOk));
  }
}
