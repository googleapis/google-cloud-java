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
package com.google.api.gax.batching;

/**
 * An extension of FlowController that tracks the number of permits and calls to reserve and release
 */
public class TrackedFlowController extends FlowController {
  private long elementsReserved = 0;
  private long elementsReleased = 0;
  private long bytesReserved = 0;
  private long bytesReleased = 0;
  private int callsToReserve = 0;
  private int callsToRelease = 0;

  public TrackedFlowController(FlowControlSettings settings) {
    super(settings);
  }

  @Override
  public void reserve(long elements, long bytes) throws FlowControlException {
    super.reserve(elements, bytes);
    this.elementsReserved += elements;
    this.bytesReserved += bytes;
    this.callsToReserve += 1;
  }

  @Override
  public void release(long elements, long bytes) {
    super.release(elements, bytes);
    this.elementsReleased += elements;
    this.bytesReleased += bytes;
    this.callsToRelease += 1;
  }

  public long getElementsReserved() {
    return elementsReserved;
  }

  public long getElementsReleased() {
    return elementsReleased;
  }

  public long getBytesReserved() {
    return bytesReserved;
  }

  public long getBytesReleased() {
    return bytesReleased;
  }

  public int getCallsToReserve() {
    return callsToReserve;
  }

  public int getCallsToRelease() {
    return callsToRelease;
  }
}
