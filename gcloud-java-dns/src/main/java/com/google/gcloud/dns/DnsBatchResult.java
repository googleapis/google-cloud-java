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
public class DnsBatchResult<T> extends BatchResult<T, DnsException> {

  DnsBatchResult() {
  }

  @Override
  public void error(DnsException error) {
    super.error(error);
  }

  @Override
  public void success(T result) {
    super.success(result);
  }
}
