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
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * An iterable of GenerateContentResponse.
 *
 * @deprecated This class and its package are deprecated. See the <a
 *     href="https://cloud.google.com/vertex-ai/generative-ai/docs/deprecations/genai-vertexai-sdk#java">
 *     migration guide</a> for more details.
 */
@Deprecated
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

  /** Makes a stream from the instance. */
  public Stream<GenerateContentResponse> stream() {
    return StreamSupport.stream(this.spliterator(), false);
  }

  /**
   * Whether the content has been consumed.
   *
   * <p>"consumed" means all the content has been iterated through.
   */
  public boolean isConsumed() {
    return iteratorWithHistory.isConsumed();
  }
}
