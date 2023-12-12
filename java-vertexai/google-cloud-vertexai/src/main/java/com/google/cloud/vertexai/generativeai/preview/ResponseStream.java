/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.vertexai.generativeai.preview;

import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/** */
public class ResponseStream<GenerateContentResponse> implements Iterable<GenerateContentResponse> {

  private ResponseStreamIteratorWithHistory<GenerateContentResponse> iteratorWithHistory;
  private boolean consumingStarted = false;

  public ResponseStream(ResponseStreamIteratorWithHistory iteratorWithHistory) {
    this.iteratorWithHistory = iteratorWithHistory;
  }

  @Override
  public Iterator<GenerateContentResponse> iterator() throws IllegalStateException {
    if (!consumingStarted) {
      consumingStarted = true;
      return iteratorWithHistory;
    } else if (iteratorWithHistory.isConsumed()) {
      return iteratorWithHistory.getHistory().iterator();
    } else {
      throw new IllegalStateException("The stream is being consumed but hasn't finished.");
    }
  }

  public Stream<GenerateContentResponse> stream() {
    return StreamSupport.stream(this.spliterator(), false);
  }

  public boolean isConsumed() {
    return iteratorWithHistory.isConsumed();
  }
}
