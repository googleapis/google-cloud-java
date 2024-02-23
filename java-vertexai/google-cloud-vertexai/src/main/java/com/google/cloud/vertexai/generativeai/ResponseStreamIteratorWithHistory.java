/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vertexai.generativeai;

import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Iterator of the ResponseStream that holds the response chunks. */
public class ResponseStreamIteratorWithHistory<GenerateContentResponse>
    implements Iterator<GenerateContentResponse> {
  Iterator serverStreamIterator = null;
  List<GenerateContentResponse> history = new ArrayList<>();
  private boolean consumed = false;

  public ResponseStreamIteratorWithHistory(Iterator serverStreamIterator) {
    this.serverStreamIterator = serverStreamIterator;
  }

  @Override
  public boolean hasNext() {
    boolean hasNextResponse = serverStreamIterator.hasNext();
    consumed = !hasNextResponse;
    return hasNextResponse;
  }

  @Override
  public GenerateContentResponse next() {
    GenerateContentResponse nextItem = (GenerateContentResponse) serverStreamIterator.next();
    history.add(nextItem);
    return nextItem;
  }

  /** Retrieve all the chunks in a stream of responses. */
  public List<GenerateContentResponse> getHistory() {
    return history;
  }

  /**
   * Whether the whole stream has been consumed.
   *
   * <p>Here "consumed" means we have reached the end of the stream.
   */
  public boolean isConsumed() {
    return consumed;
  }
}
