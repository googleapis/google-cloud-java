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

package com.google.cloud.storage.it.runner;

/**
 * Sometimes, you need to make it so that a checked exception is hidden from an action. Sometimes,
 * those checked exceptions are important for other integration purposes.
 *
 * <p>This class provides some utility methods to sneakily (not method declared) throw exceptions
 * and later unwrap any sneakily wrapped exception if it's needed.
 */
public final class SneakyException extends RuntimeException {

  public SneakyException(Throwable cause) {
    super(cause);
  }

  public static <T> T sneaky(SneakySupplier<T> t) {
    try {
      return t.get();
    } catch (Exception e) {
      throw new SneakyException(e);
    }
  }

  public static <T> T unwrap(SneakySupplier<T> t) {
    try {
      return t.get();
    } catch (SneakyException e) {
      Throwable cause = e.getCause();
      if (cause instanceof RuntimeException) {
        throw (RuntimeException) cause;
      } else {
        throw new RuntimeException(cause);
      }
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @FunctionalInterface
  public interface SneakySupplier<T> {
    T get() throws Exception;
  }
}
