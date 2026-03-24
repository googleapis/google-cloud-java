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
package com.google.api.gax.batching;

import com.google.common.base.Preconditions;

/** A threshold which accumulates a count based on the provided ElementCounter. */
public final class NumericThreshold<E> implements BatchingThreshold<E> {
  private final long threshold;
  private final ElementCounter<E> extractor;
  private long sum;

  /**
   * Constructs a NumericThreshold.
   *
   * @param threshold The value that allows an event to happen.
   * @param extractor Object that extracts a numeric value from the value object.
   */
  public NumericThreshold(long threshold, ElementCounter<E> extractor) {
    this.threshold = threshold;
    this.extractor = Preconditions.checkNotNull(extractor);
    this.sum = 0;
  }

  @Override
  public void accumulate(E e) {
    sum += extractor.count(e);
  }

  @Override
  public boolean isThresholdReached() {
    return sum >= threshold;
  }

  @Override
  public BatchingThreshold<E> copyWithZeroedValue() {
    return new NumericThreshold<E>(threshold, extractor);
  }
}
