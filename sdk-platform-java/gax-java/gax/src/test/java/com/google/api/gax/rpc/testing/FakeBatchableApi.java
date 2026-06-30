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
package com.google.api.gax.rpc.testing;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.batching.BatchEntry;
import com.google.api.gax.batching.BatchingRequestBuilder;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.gax.rpc.UnaryCallable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@InternalApi("for testing")
public class FakeBatchableApi {

  public static class LabeledIntList {
    public String label;
    public List<Integer> ints;

    public LabeledIntList(String label, Integer... numbers) {
      this(label, new ArrayList<>(Arrays.asList(numbers)));
    }

    public LabeledIntList(String label, List<Integer> ints) {
      this.label = label;
      this.ints = ints;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      LabeledIntList that = (LabeledIntList) o;

      if (!label.equals(that.label)) {
        return false;
      }
      return ints.equals(that.ints);
    }

    @Override
    public int hashCode() {
      int result = label.hashCode();
      result = 31 * result + ints.hashCode();
      return result;
    }

    public LabeledIntList clone() {
      return new LabeledIntList(this.label, new ArrayList<>(this.ints));
    }
  }

  public static LabeledIntSquarerCallable callLabeledIntSquarer = new LabeledIntSquarerCallable();

  public static class LabeledIntSquarerCallable
      extends UnaryCallable<LabeledIntList, List<Integer>> {

    @Override
    public ApiFuture<List<Integer>> futureCall(LabeledIntList request, ApiCallContext context) {
      List<Integer> result = new ArrayList<>();
      for (Integer i : request.ints) {
        result.add(i * i);
      }
      return ApiFutures.immediateFuture(result);
    }
  }

  public static SquarerBatchingDescriptor SQUARER_BATCHING_DESC = new SquarerBatchingDescriptor();

  public static class SquarerBatchingDescriptor
      implements BatchingDescriptor<LabeledIntList, List<Integer>> {

    @Override
    public PartitionKey getBatchPartitionKey(LabeledIntList request) {
      return new PartitionKey(request.label);
    }

    @Override
    public RequestBuilder<LabeledIntList> getRequestBuilder() {
      return new RequestBuilder<LabeledIntList>() {

        LabeledIntList list;

        @Override
        public void appendRequest(LabeledIntList request) {
          if (list == null) {
            list = request;
          } else {
            list.ints.addAll(request.ints);
          }
        }

        @Override
        public LabeledIntList build() {
          return list;
        }
      };
    }

    @Override
    public void splitResponse(
        List<Integer> batchResponse,
        Collection<? extends BatchedRequestIssuer<List<Integer>>> batch) {
      int batchMessageIndex = 0;
      for (BatchedRequestIssuer<List<Integer>> responder : batch) {
        List<Integer> messageIds = new ArrayList<>();
        long messageCount = responder.getMessageCount();
        for (int i = 0; i < messageCount; i++) {
          messageIds.add(batchResponse.get(batchMessageIndex));
          batchMessageIndex += 1;
        }
        responder.setResponse(messageIds);
      }
    }

    @Override
    public void splitException(
        Throwable throwable, Collection<? extends BatchedRequestIssuer<List<Integer>>> batch) {
      for (BatchedRequestIssuer<List<Integer>> responder : batch) {
        responder.setException(throwable);
      }
    }

    @Override
    public long countElements(LabeledIntList request) {
      return request.ints.size();
    }

    @Override
    public long countBytes(LabeledIntList request) {
      long counter = 0;
      for (Integer i : request.ints) {
        counter += i;
      }
      // Limit the byte size to simulate merged messages having smaller serialized size than the sum
      // of their components.
      return Math.min(counter, 5);
    }
  }

  public static SquarerBatchingDescriptorV2 SQUARER_BATCHING_DESC_V2 =
      new SquarerBatchingDescriptorV2();

  public static class SquarerBatchingDescriptorV2
      implements com.google.api.gax.batching.BatchingDescriptor<
          Integer, Integer, LabeledIntList, List<Integer>> {

    @Override
    public BatchingRequestBuilder<Integer, LabeledIntList> newRequestBuilder(
        final LabeledIntList prototype) {
      return new BatchingRequestBuilder<Integer, LabeledIntList>() {
        final LabeledIntList labelList = prototype.clone();

        @Override
        public void add(Integer element) {
          labelList.ints.add(element);
        }

        @Override
        public LabeledIntList build() {
          return labelList;
        }
      };
    }

    @Override
    public void splitResponse(
        List<Integer> batchResponse, List<BatchEntry<Integer, Integer>> batch) {
      for (int i = 0; i < batchResponse.size(); i++) {
        batch.get(i).getResultFuture().set(batchResponse.get(i));
      }
    }

    @Override
    public void splitException(Throwable throwable, List<BatchEntry<Integer, Integer>> batch) {
      for (BatchEntry<Integer, Integer> entry : batch) {
        entry.getResultFuture().setException(throwable);
      }
    }

    @Override
    public long countBytes(Integer element) {
      return 1;
    }
  }
}
