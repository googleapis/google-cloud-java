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

import com.google.api.core.InternalExtensionOnly;
import com.google.auth.Credentials;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/** An instance of TransportChannelProvider that always provides the same TransportChannel. */
@InternalExtensionOnly
public class FixedTransportChannelProvider implements TransportChannelProvider {

  private final TransportChannel transportChannel;

  private FixedTransportChannelProvider(TransportChannel transportChannel) {
    this.transportChannel = Preconditions.checkNotNull(transportChannel);
  }

  @Override
  public boolean shouldAutoClose() {
    return false;
  }

  @Override
  public boolean needsExecutor() {
    return false;
  }

  @Override
  public FixedTransportChannelProvider withExecutor(ScheduledExecutorService executor) {
    return withExecutor((Executor) executor);
  }

  @Override
  public FixedTransportChannelProvider withExecutor(Executor executor) {
    throw new UnsupportedOperationException(
        "FixedTransportChannelProvider doesn't need an executor");
  }

  @Override
  public boolean needsHeaders() {
    return false;
  }

  @Override
  public FixedTransportChannelProvider withHeaders(Map<String, String> headers) {
    throw new UnsupportedOperationException("FixedTransportChannelProvider doesn't need headers");
  }

  @Override
  public boolean needsEndpoint() {
    return false;
  }

  @Override
  public TransportChannelProvider withEndpoint(String endpoint) {
    throw new UnsupportedOperationException(
        "FixedTransportChannelProvider doesn't need an endpoint");
  }

  /**
   * @deprecated FixedTransportChannelProvider doesn't support ChannelPool configuration
   */
  @Deprecated
  @Override
  public boolean acceptsPoolSize() {
    return false;
  }

  /**
   * @deprecated FixedTransportChannelProvider doesn't support ChannelPool configuration
   */
  @Deprecated
  @Override
  public TransportChannelProvider withPoolSize(int size) {
    throw new UnsupportedOperationException(
        "FixedTransportChannelProvider doesn't allow pool size customization");
  }

  @Override
  public TransportChannel getTransportChannel() throws IOException {
    return transportChannel;
  }

  @Override
  public String getTransportName() {
    return transportChannel.getTransportName();
  }

  @Override
  public boolean needsCredentials() {
    return false;
  }

  @Override
  public TransportChannelProvider withCredentials(Credentials credentials) {
    throw new UnsupportedOperationException(
        "FixedTransportChannelProvider doesn't need credentials");
  }

  /** Creates a FixedTransportChannelProvider. */
  public static FixedTransportChannelProvider create(TransportChannel transportChannel) {
    return new FixedTransportChannelProvider(transportChannel);
  }
}
