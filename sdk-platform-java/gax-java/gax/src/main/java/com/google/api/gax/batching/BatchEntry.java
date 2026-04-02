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

import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.auto.value.AutoValue;
import javax.annotation.Nullable;

/**
 * This class contains the element and its corresponding unresolved future, which would be resolved
 * when batch is {@link BatchingDescriptor#splitResponse successful} or {@link
 * BatchingDescriptor#splitException failed}.
 *
 * @param <ElementT> The type of each individual element to be batched.
 * @param <ElementResultT> The type of the result for each individual element.
 */
@InternalApi("For google-cloud-java client use only.")
@AutoValue
public abstract class BatchEntry<ElementT, ElementResultT> {

  /** Returns a new BatchEntry */
  public static <ElementT, ElementResultT> BatchEntry<ElementT, ElementResultT> create(
      @Nullable ElementT element, SettableApiFuture<ElementResultT> resultFuture) {
    return new AutoValue_BatchEntry<>(element, resultFuture);
  }

  @Nullable
  public abstract ElementT getElement();

  public abstract SettableApiFuture<ElementResultT> getResultFuture();
}
