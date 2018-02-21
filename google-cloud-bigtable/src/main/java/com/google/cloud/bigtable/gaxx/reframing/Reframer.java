/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.gaxx.reframing;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;

/**
 * Interface for the business logic of a stream transformation. All methods will be called in a
 * synchronized block, so implementations don't need to be thread safe or be concerned with back
 * pressure.
 *
 * <p>The flow is:
 *
 * <pre>
 * hasFullFrame?
 *  -&gt; true -&gt; pop()
 *  -&gt; false
 *    -&gt; upstream complete?
 *      -&gt; true
 *        -&gt; hasPartialFrame?
 *          -&gt; true
 *            =&gt; notify error
 *          -&gt; false
 *            =&gt; notify complete
 *      -&gt; false
 *        =&gt; push() and restart at hasFullFrame?
 * </pre>
 *
 * @param <InnerT> The type of responses coming from the inner ServerStreamingCallable.
 * @param <OuterT> The type of responses the outer {@link com.google.api.gax.rpc.ResponseObserver}
 *     expects.
 */
@InternalApi
public interface Reframer<OuterT, InnerT> {
  /**
   * Refill internal buffers with inner/upstream response. Should only be invoked if {@link
   * #hasFullFrame} returns false.
   */
  void push(InnerT response);

  /**
   * Checks if there is a frame to be popped.
   *
   * <p>Note that this method might update internal to buffer the next response.
   */
  boolean hasFullFrame();

  /** Checks if there is any incomplete data. Used to check if the stream closed prematurely. */
  boolean hasPartialFrame();

  /**
   * Returns and removes the current completed frame. Should only be called if hasFullFrame returns
   * true.
   */
  OuterT pop();
}
