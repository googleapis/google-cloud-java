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

import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.common.truth.Truth;
import java.util.Collections;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.Test;

class FixedTransportChannelProviderTest {
  @Test
  void testBasic() throws Exception {
    TransportChannel transportChannel = FakeTransportChannel.create(new FakeChannel());
    FixedTransportChannelProvider provider = FixedTransportChannelProvider.create(transportChannel);

    Truth.assertThat(provider.shouldAutoClose()).isFalse();

    Truth.assertThat(provider.needsExecutor()).isFalse();

    Exception thrownException = null;
    try {
      provider.withExecutor(new ScheduledThreadPoolExecutor(0));
    } catch (Exception e) {
      thrownException = e;
    }
    Truth.assertThat(thrownException).isInstanceOf(UnsupportedOperationException.class);

    Truth.assertThat(provider.needsHeaders()).isFalse();

    thrownException = null;
    try {
      provider.withHeaders(Collections.<String, String>emptyMap());
    } catch (Exception e) {
      thrownException = e;
    }
    Truth.assertThat(thrownException).isInstanceOf(UnsupportedOperationException.class);

    Truth.assertThat(provider.needsEndpoint()).isFalse();

    thrownException = null;
    try {
      provider.withEndpoint("localhost:8080");
    } catch (Exception e) {
      thrownException = e;
    }
    Truth.assertThat(thrownException).isInstanceOf(UnsupportedOperationException.class);

    Truth.assertThat(provider.needsCredentials()).isFalse();

    thrownException = null;
    try {
      provider.withCredentials(ComputeEngineCredentials.create());
    } catch (Exception e) {
      thrownException = e;
    }
    Truth.assertThat(thrownException).isInstanceOf(UnsupportedOperationException.class);

    Truth.assertThat(provider.acceptsPoolSize()).isFalse();

    thrownException = null;
    try {
      provider.withPoolSize(1);
    } catch (Exception e) {
      thrownException = e;
    }
    Truth.assertThat(thrownException).isInstanceOf(UnsupportedOperationException.class);

    Truth.assertThat(provider.getTransportChannel()).isSameInstanceAs(transportChannel);

    Truth.assertThat(provider.getTransportName())
        .isEqualTo(FakeTransportChannel.getFakeTransportName());
  }
}
