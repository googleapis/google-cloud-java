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

import com.google.api.core.InternalApi;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;

/** Forwarding implementation of ResultSet that forwards all calls to a delegate. */
public class ForwardingResultSet extends ForwardingStructReader
    implements ProtobufResultSet, StreamingResultSet {

  private Supplier<? extends ResultSet> delegate;

  public ForwardingResultSet(ResultSet delegate) {
    super(delegate);
    this.delegate = Suppliers.ofInstance(Preconditions.checkNotNull(delegate));
  }

  public ForwardingResultSet(Supplier<? extends ResultSet> supplier) {
    super(supplier);
    this.delegate = supplier;
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
    this.delegate = Suppliers.ofInstance(Preconditions.checkNotNull(newDelegate));
  }

  ResultSet getDelegate() {
    return delegate.get();
  }

  @Override
  public boolean next() throws SpannerException {
    return delegate.get().next();
  }

  @Override
  public boolean canGetProtobufValue(int columnIndex) {
    ResultSet resultSetDelegate = delegate.get();
    return (resultSetDelegate instanceof ProtobufResultSet)
        && ((ProtobufResultSet) resultSetDelegate).canGetProtobufValue(columnIndex);
  }

  @Override
  public com.google.protobuf.Value getProtobufValue(int columnIndex) {
    ResultSet resultSetDelegate = delegate.get();
    Preconditions.checkState(
        resultSetDelegate instanceof ProtobufResultSet,
        "The result set does not support protobuf values");
    return ((ProtobufResultSet) resultSetDelegate).getProtobufValue(columnIndex);
  }

  @Override
  public Struct getCurrentRowAsStruct() {
    return delegate.get().getCurrentRowAsStruct();
  }

  @Override
  public void close() {
    ResultSet rs;
    try {
      rs = delegate.get();
    } catch (Exception e) {
      // Ignore any exceptions when getting the underlying result set, as that means that there is
      // nothing that needs to be closed.
      return;
    }
    rs.close();
  }

  @Override
  public ResultSetStats getStats() {
    return delegate.get().getStats();
  }

  @Override
  public ResultSetMetadata getMetadata() {
    return delegate.get().getMetadata();
  }

  @Override
  @InternalApi
  public boolean initiateStreaming(AsyncResultSet.StreamMessageListener streamMessageListener) {
    return StreamingUtil.initiateStreaming(delegate.get(), streamMessageListener);
  }
}
