/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.common.base.Preconditions;
import com.google.spanner.v1.ResultSetStats;

/** Forwarding implementation of ResultSet that forwards all calls to a delegate. */
public class ForwardingResultSet extends ForwardingStructReader implements ResultSet {

  private ResultSet delegate;

  public ForwardingResultSet(ResultSet delegate) {
    super(delegate);
    this.delegate = Preconditions.checkNotNull(delegate);
  }

  /**
   * Replaces the underlying {@link ResultSet}. It is the responsibility of the caller to ensure
   * that the new delegate has the same properties and is in the same state as the original
   * delegate. This method can be used if the underlying delegate needs to be replaced after a
   * session or transaction needed to be restarted after the {@link ResultSet} had already been
   * returned to the user.
   */
  void replaceDelegate(ResultSet newDelegate) {
    Preconditions.checkNotNull(newDelegate);
    super.replaceDelegate(newDelegate);
    this.delegate = newDelegate;
  }

  @Override
  public boolean next() throws SpannerException {
    return delegate.next();
  }

  @Override
  public Struct getCurrentRowAsStruct() {
    return delegate.getCurrentRowAsStruct();
  }

  @Override
  public void close() {
    delegate.close();
  }

  @Override
  public ResultSetStats getStats() {
    return delegate.getStats();
  }
}
