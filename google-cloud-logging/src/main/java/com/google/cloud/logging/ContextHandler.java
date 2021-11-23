/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

/** Class provides a per-thread storage of the {@see Context} instances. */
public class ContextHandler {
  private static final ThreadLocal<Context> contextHolder = initContextHolder();

  /**
   * Initializes the context holder to {@link InheritableThreadLocal} if {@link LogManager}
   * configuration property {@code com.google.cloud.logging.ContextHandler.useInheritedContext} is
   * set to {@code true} or to {@link ThreadLocal} otherwise.
   *
   * @return instance of the context holder.
   */
  private static ThreadLocal<Context> initContextHolder() {
    LoggingConfig config = new LoggingConfig(ContextHandler.class.getName());
    if (config.getUseInheritedContext()) {
      return new InheritableThreadLocal<>();
    } else {
      return new ThreadLocal<>();
    }
  }

  public Context getCurrentContext() {
    return contextHolder.get();
  }

  public void setCurrentContext(Context context) {
    contextHolder.set(context);
  }

  public void removeCurrentContext() {
    contextHolder.remove();
  }
}
