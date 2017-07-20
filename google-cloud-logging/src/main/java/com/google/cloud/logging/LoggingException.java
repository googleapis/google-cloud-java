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

package com.google.cloud.logging;

import com.google.api.gax.grpc.GrpcApiException;
import com.google.cloud.grpc.BaseGrpcServiceException;
import java.io.IOException;

/**
 * Logging service exception.
 */
public final class LoggingException extends BaseGrpcServiceException {

  private static final long serialVersionUID = 449689219311927047L;

  public LoggingException(IOException ex, boolean idempotent) {
    super(ex, idempotent);
  }

  public LoggingException(GrpcApiException apiException) {
    super(apiException);
  }
}
