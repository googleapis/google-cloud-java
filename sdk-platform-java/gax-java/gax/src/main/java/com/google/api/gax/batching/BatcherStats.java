/*
 * Copyright 2019 Google LLC
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
package com.google.api.gax.batching;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.collect.EvictingQueue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Keeps the statistics about failed operations(both at RPC and ElementT) in {@link Batcher}. This
 * provides the count of individual exception failure and count of each failed {@link Code} occurred
 * in the batching process.
 */
class BatcherStats {

  private final Map<Class, Integer> requestExceptionCounts = new HashMap<>();
  private final Map<Code, Integer> requestStatusCounts = new HashMap<>();
  private int requestPartialFailureCount;

  private final Map<Class, Integer> entryExceptionCounts = new HashMap<>();
  private final Map<Code, Integer> entryStatusCounts = new HashMap<>();

  /**
   * The maximum number of error messages that a Batcher instance will retain. By default, a Batcher
   * instance will retain 50 entry error messages and 50 RPC error messages. This limit can be
   * temporarily increased by setting the {@code com.google.api.gax.batching.errors.max-samples}
   * system property. This should only be needed in very rare situations and should not be
   * considered part of the public api.
   */
  private final int MAX_ERROR_MSG_SAMPLES =
      Integer.getInteger("com.google.api.gax.batching.errors.max-samples", 50);

  private final EvictingQueue<String> sampleOfRpcErrors =
      EvictingQueue.create(MAX_ERROR_MSG_SAMPLES);
  private final EvictingQueue<String> sampleOfEntryErrors =
      EvictingQueue.create(MAX_ERROR_MSG_SAMPLES);

  /**
   * Records the count of the exception and it's type when a complete batch failed to apply.
   *
   * <p>Note: This method aggregates all the subclasses of {@link ApiException} under ApiException
   * using the {@link Code status codes} and its number of occurrences.
   */
  synchronized void recordBatchFailure(Throwable throwable) {
    Class exceptionClass = throwable.getClass();

    if (throwable instanceof ApiException) {
      Code code = ((ApiException) throwable).getStatusCode().getCode();
      exceptionClass = ApiException.class;

      int oldStatusCount = MoreObjects.firstNonNull(requestStatusCounts.get(code), 0);
      requestStatusCounts.put(code, oldStatusCount + 1);
    }

    sampleOfRpcErrors.add(throwable.toString());

    int oldExceptionCount = MoreObjects.firstNonNull(requestExceptionCounts.get(exceptionClass), 0);
    requestExceptionCounts.put(exceptionClass, oldExceptionCount + 1);
  }

  /**
   * Records partial failures within each batch. partialBatchFailures counts the number of batches
   * that have at least one failed entry while entryStatusCounts and entryExceptionCounts track the
   * count of the entries themselves.
   *
   * <p>Note: This method aggregates all the subclasses of {@link ApiException} under ApiException
   * using the {@link Code status codes} and its number of occurrences.
   */
  synchronized <T extends BatchEntry> void recordBatchElementsCompletion(
      List<T> batchElementResultFutures) {
    boolean isRequestPartiallyFailed = false;
    for (final BatchEntry elementResult : batchElementResultFutures) {
      try {
        elementResult.getResultFuture().get();
      } catch (Throwable throwable) {

        if (!isRequestPartiallyFailed) {
          isRequestPartiallyFailed = true;
          requestPartialFailureCount++;
        }
        Throwable actualCause = throwable.getCause();
        Class exceptionClass = actualCause.getClass();

        sampleOfEntryErrors.add(actualCause.toString());

        if (actualCause instanceof ApiException) {
          Code code = ((ApiException) actualCause).getStatusCode().getCode();
          exceptionClass = ApiException.class;

          int oldStatusCount = MoreObjects.firstNonNull(entryStatusCounts.get(code), 0);
          entryStatusCounts.put(code, oldStatusCount + 1);
        }

        int oldExceptionCount =
            MoreObjects.firstNonNull(entryExceptionCounts.get(exceptionClass), 0);
        entryExceptionCounts.put(exceptionClass, oldExceptionCount + 1);
      }
    }
  }

  /** Calculates and formats the message with request and entry failure count. */
  @Nullable
  synchronized BatchingException asException() {
    if (requestExceptionCounts.isEmpty() && requestPartialFailureCount == 0) {
      return null;
    }

    StringBuilder messageBuilder = new StringBuilder();
    messageBuilder.append("Batching finished with ");

    if (!requestExceptionCounts.isEmpty()) {
      messageBuilder
          .append(
              String.format("%d batches failed to apply due to: ", requestExceptionCounts.size()))
          .append(buildExceptionList(requestExceptionCounts, requestStatusCounts))
          .append(" and ");
    }

    messageBuilder.append(String.format("%d partial failures.", requestPartialFailureCount));
    if (requestPartialFailureCount > 0) {
      int totalEntriesCount = 0;
      for (Integer count : entryExceptionCounts.values()) {
        totalEntriesCount += count;
      }

      messageBuilder
          .append(
              String.format(
                  " The %d partial failures contained %d entries that failed with: ",
                  requestPartialFailureCount, totalEntriesCount))
          .append(buildExceptionList(entryExceptionCounts, entryStatusCounts))
          .append(".");
    }

    if (!sampleOfRpcErrors.isEmpty()) {
      messageBuilder.append(" Sample of RPC errors: ");
      messageBuilder.append(Joiner.on(", ").join(sampleOfRpcErrors));
      messageBuilder.append(".");
    }
    if (!sampleOfEntryErrors.isEmpty()) {
      messageBuilder.append(" Sample of entry errors: ");
      messageBuilder.append(Joiner.on(", ").join(sampleOfEntryErrors));
      messageBuilder.append(".");
    }
    return new BatchingException(messageBuilder.toString());
  }

  /**
   * Prints the class name and it's count along with {@link Code status code} and it's counts.
   *
   * <p>Example: "1 IllegalStateException, 1 ApiException(1 UNAVAILABLE, 1 ALREADY_EXISTS)".
   */
  private String buildExceptionList(
      Map<Class, Integer> exceptionCounts, Map<Code, Integer> statusCounts) {
    StringBuilder messageBuilder = new StringBuilder();
    Iterator<Map.Entry<Class, Integer>> exceptionIterator = exceptionCounts.entrySet().iterator();

    while (exceptionIterator.hasNext()) {
      Map.Entry<Class, Integer> request = exceptionIterator.next();
      messageBuilder.append(
          String.format("%d %s", request.getValue(), request.getKey().getSimpleName()));

      if (ApiException.class.equals(request.getKey())) {
        messageBuilder.append("(");
        Iterator<Map.Entry<Code, Integer>> statusIterator = statusCounts.entrySet().iterator();
        while (statusIterator.hasNext()) {
          Map.Entry<Code, Integer> statusCode = statusIterator.next();
          messageBuilder.append(String.format("%d %s", statusCode.getValue(), statusCode.getKey()));
          if (statusIterator.hasNext()) {
            messageBuilder.append(", ");
          }
        }
        messageBuilder.append(")");
      }
      if (exceptionIterator.hasNext()) {
        messageBuilder.append(", ");
      }
    }

    return messageBuilder.toString();
  }
}
