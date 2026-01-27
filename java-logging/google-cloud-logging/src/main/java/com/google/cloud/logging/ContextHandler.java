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

  public enum ContextPriority {
    NO_INPUT,
    XCLOUD_HEADER,
    W3C_HEADER,
    OTEL_EXTRACTED
  }

  private static final ThreadLocal<Context> contextHolder = initContextHolder();
  private static final ThreadLocal<ContextPriority> currentPriority =
      ThreadLocal.withInitial(() -> ContextPriority.NO_INPUT);

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
    setCurrentContext(context, ContextPriority.NO_INPUT);
  }

  public ContextPriority getCurrentContextPriority() {
    return currentPriority.get();
  }

  /**
   * Sets the context based on the priority. Overrides traceId, spanId and TraceSampled if the
   * passed priority is higher. HttpRequest values will be retrieved and combined from existing
   * context if HttpRequest in the new context is empty .
   */
  public void setCurrentContext(Context context, ContextPriority priority) {
    if (priority != null && priority.compareTo(currentPriority.get()) >= 0 && context != null) {
      Context.Builder combinedContextBuilder =
          Context.newBuilder()
              .setTraceId(context.getTraceId())
              .setSpanId(context.getSpanId())
              .setTraceSampled(context.getTraceSampled());
      Context currentContext = getCurrentContext();

      if (context.getHttpRequest() != null) {
        combinedContextBuilder.setRequest(context.getHttpRequest());
      }
      // Combines HttpRequest from the existing context if HttpRequest in new context is empty.
      else if (currentContext != null && currentContext.getHttpRequest() != null) {
        combinedContextBuilder.setRequest(currentContext.getHttpRequest());
      }

      contextHolder.set(combinedContextBuilder.build());
      currentPriority.set(priority);
    }
  }

  public void removeCurrentContext() {
    contextHolder.remove();
  }

  public void removeCurrentContextPriority() {
    currentPriority.remove();
  }
}
