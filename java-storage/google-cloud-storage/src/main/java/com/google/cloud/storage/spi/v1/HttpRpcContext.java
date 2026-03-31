/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.spi.v1;

import com.google.api.core.InternalApi;
import java.util.UUID;
import java.util.function.Supplier;
import javax.annotation.Nullable;

@InternalApi
public final class HttpRpcContext {

  private static final Object GET_INSTANCE_LOCK = new Object();

  private static volatile HttpRpcContext instance;

  private final ThreadLocal<UUID> invocationId;
  private final Supplier<UUID> supplier;

  HttpRpcContext(Supplier<UUID> randomUUID) {
    this.invocationId = new InheritableThreadLocal<>();
    this.supplier = randomUUID;
  }

  @InternalApi
  @Nullable
  public UUID getInvocationId() {
    return invocationId.get();
  }

  @InternalApi
  public UUID newInvocationId() {
    invocationId.set(supplier.get());
    return getInvocationId();
  }

  @InternalApi
  public void clearInvocationId() {
    invocationId.remove();
  }

  @InternalApi
  public static HttpRpcContext init() {
    return new HttpRpcContext(UUID::randomUUID);
  }

  @InternalApi
  public static HttpRpcContext getInstance() {
    if (instance == null) {
      synchronized (GET_INSTANCE_LOCK) {
        if (instance == null) {
          instance = init();
        }
      }
    }
    return instance;
  }
}
