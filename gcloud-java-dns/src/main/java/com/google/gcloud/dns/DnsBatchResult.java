/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.dns;

import com.google.gcloud.BatchResult;

/**
 * This class holds a single result of a batch call to the Cloud DNS.
 */
public class DnsBatchResult<T> implements BatchResult<T, DnsException> {

  private T result;
  private boolean submitted = false;
  private DnsException error;

  DnsBatchResult() {
  }

  @Override
  public boolean submitted() {
    return submitted;
  }

  @Override
  public T get() throws DnsException {
    if (!submitted()) {
      throw new IllegalStateException("Batch has not been submitted yet");
    }
    if (error != null) {
      throw error;
    }
    return result;
  }

  @Override
  public void notify(Callback<T, DnsException> callback) {
    // todo(mderka) implement
    throw new UnsupportedOperationException("Not implemented yet");
  }

  void error(DnsException error) {
    this.error = error;
    this.submitted = true;
  }

  void success(T result) {
    this.result = result;
    this.submitted = true;
  }
}
