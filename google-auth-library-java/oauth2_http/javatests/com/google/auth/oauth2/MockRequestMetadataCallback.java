/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
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

package com.google.auth.oauth2;

import com.google.auth.RequestMetadataCallback;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/** Mock RequestMetadataCallback */
public final class MockRequestMetadataCallback implements RequestMetadataCallback {
  volatile Map<String, List<String>> metadata;
  volatile Throwable exception;
  CountDownLatch latch = new CountDownLatch(1);

  /** Called when metadata is successfully produced. */
  @Override
  public void onSuccess(Map<String, List<String>> metadata) {
    checkNotSet();
    this.metadata = metadata;
    latch.countDown();
  }

  /** Called when metadata generation failed. */
  @Override
  public void onFailure(Throwable exception) {
    checkNotSet();
    this.exception = exception;
    latch.countDown();
  }

  public void reset() {
    this.metadata = null;
    this.exception = null;
    latch = new CountDownLatch(1);
  }

  public Map<String, List<String>> awaitResult() throws Throwable {
    latch.await();
    if (exception != null) {
      throw exception;
    } else {
      return metadata;
    }
  }

  private void checkNotSet() {
    Preconditions.checkState(this.metadata == null);
    Preconditions.checkState(this.exception == null);
  }
}
