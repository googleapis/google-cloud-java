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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeSimpleApi.StashCallable;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/** Tests for {@link UnaryCallable}. */
class UnaryCallableTest {

  @Test
  void simpleCall() throws Exception {
    StashCallable<Integer, Integer> stashCallable = new StashCallable<>(1);

    Integer response = stashCallable.call(2, FakeCallContext.createDefault());
    assertEquals(Integer.valueOf(1), response);
    FakeCallContext callContext = (FakeCallContext) stashCallable.getContext();
    assertNull(callContext.getChannel());
    assertNull(callContext.getCredentials());
  }

  @Test
  void call() throws Exception {
    ApiCallContext defaultCallContext = FakeCallContext.createDefault();
    StashCallable<Integer, Integer> stashCallable = new StashCallable<>(1);
    UnaryCallable<Integer, Integer> callable =
        stashCallable.withDefaultCallContext(defaultCallContext);

    Integer response = callable.call(2);
    assertEquals(Integer.valueOf(1), response);
    assertNotNull(stashCallable.getContext());
    assertSame(defaultCallContext, stashCallable.getContext());
  }

  @Test
  void callWithContext() throws Exception {
    FakeChannel channel = new FakeChannel();
    Credentials credentials = Mockito.mock(Credentials.class);
    RetrySettings retrySettings = Mockito.mock(RetrySettings.class);
    Set<StatusCode.Code> retryableCodes =
        ImmutableSet.of(
            StatusCode.Code.INTERNAL,
            StatusCode.Code.UNAVAILABLE,
            StatusCode.Code.DEADLINE_EXCEEDED);
    ApiCallContext context =
        FakeCallContext.createDefault()
            .withChannel(channel)
            .withCredentials(credentials)
            .withRetrySettings(retrySettings)
            .withRetryableCodes(retryableCodes);
    StashCallable<Integer, Integer> stashCallable = new StashCallable<>(1);
    UnaryCallable<Integer, Integer> callable =
        stashCallable.withDefaultCallContext(FakeCallContext.createDefault());

    Integer response = callable.call(2, context);
    assertEquals(Integer.valueOf(1), response);
    FakeCallContext actualContext = (FakeCallContext) stashCallable.getContext();
    assertSame(channel, actualContext.getChannel());
    assertSame(credentials, actualContext.getCredentials());
    assertSame(retrySettings, actualContext.getRetrySettings());
    assertThat(actualContext.getRetryableCodes()).containsExactlyElementsIn(retryableCodes);
  }
}
