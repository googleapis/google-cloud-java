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

import com.google.common.util.concurrent.ListenableFuture;

class DatabaseClientImpl implements DatabaseClient {

  private final SessionPool pool;

  DatabaseClientImpl(SessionPool pool) {
    this.pool = pool;
  }

  @Override
  public Timestamp write(Iterable<Mutation> mutations) throws SpannerException {
    return pool.getReadWriteSession().write(mutations);
  }

  @Override
  public Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException {
    return pool.getReadSession().writeAtLeastOnce(mutations);
  }

  @Override
  public ReadContext singleUse() {
    return pool.getReadSession().singleUse();
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    return pool.getReadSession().singleUse(bound);
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    return pool.getReadSession().singleUseReadOnlyTransaction();
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    return pool.getReadSession().singleUseReadOnlyTransaction(bound);
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    return pool.getReadSession().readOnlyTransaction();
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    return pool.getReadSession().readOnlyTransaction(bound);
  }

  @Override
  public TransactionRunner readWriteTransaction() {
    return pool.getReadWriteSession().readWriteTransaction();
  }

  ListenableFuture<Void> closeAsync() {
    return pool.closeAsync();
  }
}
