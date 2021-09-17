/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import com.google.api.gax.rpc.BidiStream;
import com.google.common.collect.Lists;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import java.util.Iterator;

public class LogEntryServerStream implements Iterable<LogEntry> {
  private final BidiStream<TailLogEntriesRequest, TailLogEntriesResponse> serverStream;

  LogEntryServerStream(BidiStream<TailLogEntriesRequest, TailLogEntriesResponse> serverStream) {
    this.serverStream = serverStream;
  }

  /** {@inheritDoc} */
  @Override
  public Iterator<LogEntry> iterator() {
    return new LogEntryIterator(serverStream.iterator());
  }

  public BidiStream<TailLogEntriesRequest, TailLogEntriesResponse> getInternalStream() {
    return serverStream;
  }

  public java.util.List<LogEntry> convert(TailLogEntriesResponse resp) {
    return Lists.transform(resp.getEntriesList(), LogEntry.FROM_PB_FUNCTION);
  }

  /**
   * Returns true if the next call to the iterator's hasNext() or next() is guaranteed to be
   * nonblocking.
   *
   * @return If the call on any of the iterator's methods is guaranteed to be nonblocking.
   */
  public boolean isReceiveReady() {
    return serverStream.isReceiveReady();
  }

  /**
   * Cleanly cancels a partially consumed stream. The associated iterator will return false for the
   * hasNext() in the next iteration. This maintains the contract that an observed true from
   * hasNext() will yield an item in next(), but afterwards will return false.
   */
  public void cancel() {
    serverStream.cancel();
  }
}
