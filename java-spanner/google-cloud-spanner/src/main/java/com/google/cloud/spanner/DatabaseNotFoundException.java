/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.spanner.SpannerException.ResourceNotFoundException;
import com.google.rpc.ResourceInfo;
import javax.annotation.Nullable;

/**
 * Exception thrown by Cloud Spanner when an operation detects that the database that is being used
 * no longer exists. This type of error has its own subclass as it is a condition that should cause
 * the client library to stop trying to send RPCs to the backend until the user has taken action.
 */
public class DatabaseNotFoundException extends ResourceNotFoundException {
  private static final long serialVersionUID = -6395746612598975751L;

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  DatabaseNotFoundException(
      DoNotConstructDirectly token,
      @Nullable String message,
      ResourceInfo resourceInfo,
      @Nullable Throwable cause) {
    this(token, message, resourceInfo, cause, null);
  }

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  DatabaseNotFoundException(
      DoNotConstructDirectly token,
      @Nullable String message,
      ResourceInfo resourceInfo,
      @Nullable Throwable cause,
      @Nullable ApiException apiException) {
    super(token, message, resourceInfo, cause, apiException);
  }
}
