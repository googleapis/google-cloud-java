/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage;

/**
 * This exception is used to preserve the caller's stacktrace when invoking an async task in a sync
 * context. It will be added as a suppressed exception when propagating the async exception. This
 * allows callers to catch ApiException thrown in an async operation, while still maintaining the
 * call site.
 */
public final class AsyncStorageTaskException extends RuntimeException {
  // mimic of com.google.api.gax.rpc.AsyncTaskException which doesn't have a public constructor
  // if that class is ever made public, make this class extend it
  AsyncStorageTaskException() {
    super("Asynchronous task failed");
  }
}
