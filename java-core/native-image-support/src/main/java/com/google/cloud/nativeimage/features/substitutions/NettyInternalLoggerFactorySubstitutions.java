/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.nativeimage.features.substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import io.grpc.netty.shaded.io.netty.util.internal.logging.InternalLoggerFactory;
import io.grpc.netty.shaded.io.netty.util.internal.logging.JdkLoggerFactory;
import java.util.function.BooleanSupplier;

/**
 * Substitutions for {@link InternalLoggerFactory} which are needed to avoid dynamic loading of
 * logging library.
 */
@TargetClass(
    className = "io.grpc.netty.shaded.io.netty.util.internal.logging.InternalLoggerFactory",
    onlyWith = NettyInternalLoggerFactorySubstitutions.OnlyIfInClassPath.class)
final class NettyInternalLoggerFactorySubstitutions {

  @Substitute
  private static InternalLoggerFactory newDefaultFactory(String name) {
    return JdkLoggerFactory.INSTANCE;
  }

  static class OnlyIfInClassPath implements BooleanSupplier {

    @Override
    public boolean getAsBoolean() {
      try {
        // Note: Set initialize = false to avoid initializing the class when looking it up.
        Class.forName(
            "io.grpc.netty.shaded.io.netty.util.internal.logging.InternalLoggerFactory",
            false,
            Thread.currentThread().getContextClassLoader());
        return true;
      } catch (ClassNotFoundException e) {
        return false;
      }
    }
  }
}
