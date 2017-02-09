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

package com.google.cloud.pubsub.deprecated;

import com.google.api.gax.grpc.ApiException;
import com.google.cloud.BaseServiceException;

import java.io.IOException;
import java.util.Set;

/**
 * Pub/Sub service exception.
 *
 * @see <a href="https://cloud.google.com/pubsub/error-codes">Google Cloud Pub/Sub error codes</a>
 */
public final class PubSubException extends BaseServiceException {

  private static final long serialVersionUID = 6434989638600001226L;

  public PubSubException(IOException ex, boolean idempotent) {
    super(ex, idempotent);
  }

  public PubSubException(ApiException apiException, boolean idempotent) {
    super(apiException, idempotent);
  }

  @Override
  protected Set<Error> getRetryableErrors() {
    return null;
  }
}
