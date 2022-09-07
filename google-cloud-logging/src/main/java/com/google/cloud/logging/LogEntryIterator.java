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

import com.google.common.collect.Lists;
import com.google.logging.v2.TailLogEntriesResponse;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * The class implements {@see Iterator} interface over {@see LogEntry} by iterating through {@see
 * TailLogEntriesResponse} streamed by {@code BidiStream}. This class is instantiated by {@see
 * LogEntryServerStream} and is not intended to be used explicitly.
 */
public class LogEntryIterator implements Iterator<LogEntry> {
  // TODO: consider converting this to use generics instead of
  // fixed TailLogEntriesResponse
  private final Iterator<TailLogEntriesResponse> streamIterator;
  private final ArrayDeque<LogEntry> buffer = new ArrayDeque<>();

  LogEntryIterator(Iterator<TailLogEntriesResponse> streamIterator) {
    this.streamIterator = streamIterator;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasNext() {
    return !buffer.isEmpty() || streamIterator.hasNext();
  }

  /** {@inheritDoc} */
  @Override
  public LogEntry next() {
    if (buffer.isEmpty()) {
      TailLogEntriesResponse response = streamIterator.next();
      buffer.addAll(Lists.transform(response.getEntriesList(), LogEntry.FROM_PB_FUNCTION));
    }
    return buffer.pop();
  }
}
