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

import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakePagedApi.ListIntegersPagedResponse;
import com.google.api.gax.rpc.testing.FakePagedApi.ListIntegersPagedResponseFactory;
import com.google.api.gax.rpc.testing.FakePagedApi.PagedStashCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class PagedCallableTest {

  @Test
  void futureCall() {
    List<List<Integer>> results =
        Arrays.asList(
            Arrays.asList(0, 1, 2), Arrays.asList(3, 4), Collections.<Integer>emptyList());
    PagedStashCallable callable = new PagedStashCallable(results);
    PagedCallable<Integer, List<Integer>, ListIntegersPagedResponse> pagedCallable =
        new PagedCallable<>(callable, new ListIntegersPagedResponseFactory());

    Truth.assertThat(
            ImmutableList.copyOf(
                pagedCallable.call(0, FakeCallContext.createDefault()).iterateAll()))
        .containsExactly(0, 1, 2, 3, 4)
        .inOrder();
  }

  @Test
  void testToString() {
    PagedStashCallable stash = new PagedStashCallable(null);
    PagedCallable<Integer, List<Integer>, ListIntegersPagedResponse> pagedCallable =
        new PagedCallable<>(stash, new ListIntegersPagedResponseFactory());
    Truth.assertThat(pagedCallable.toString()).contains("paged");
  }
}
