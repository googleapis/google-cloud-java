/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

  private final ResultSet delegate;

  public ForwardingResultSet(ResultSet delegate) {
    super(delegate);
    this.delegate = Preconditions.checkNotNull(delegate);
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
