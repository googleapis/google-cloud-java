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

package com.google.cloud.nativeimage.features;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/**
 * A optional feature which registers reflective usages of the GRPC Protobuf libraries.
 *
 * <p>This feature is only needed if you need to access proto objects reflectively (such as
 * printing/logging proto objects).
 *
 * <p>To add this feature, add "--feature
 * com.google.cloud.nativeimage.features.ProtobufMessageFeature" to your GraalVM configuration.
 */
final class ProtobufMessageFeature implements Feature {

  // Proto classes to check on the classpath.
  private static final String PROTO_MESSAGE_CLASS = "com.google.protobuf.GeneratedMessageV3";
  private static final String PROTO_ENUM_CLASS = "com.google.protobuf.ProtocolMessageEnum";
  private static final String ENUM_VAL_DESCRIPTOR_CLASS =
      "com.google.protobuf.Descriptors$EnumValueDescriptor";

  // Prefixes of methods accessed reflectively by
  // com.google.protobuf.GeneratedMessageV3$ReflectionInvoker
  private static final List<String> METHOD_ACCESSOR_PREFIXES =
      Arrays.asList("get", "set", "has", "add", "clear", "newBuilder");

  @Override
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    Class<?> protoMessageClass = access.findClassByName(PROTO_MESSAGE_CLASS);
    if (protoMessageClass != null) {
      Method internalAccessorMethod =
          NativeImageUtils.getMethodOrFail(protoMessageClass, "internalGetFieldAccessorTable");

      // Finds every class whose `internalGetFieldAccessorTable()` is reached and registers it.
      // `internalGetFieldAccessorTable()` is used downstream to access the class reflectively.
      access.registerMethodOverrideReachabilityHandler(
          (duringAccess, method) -> {
            registerFieldAccessors(method.getDeclaringClass());
            registerFieldAccessors(getBuilderClass(method.getDeclaringClass()));
          },
          internalAccessorMethod);
    }

    Class<?> protoEnumClass = access.findClassByName(PROTO_ENUM_CLASS);
    if (protoEnumClass != null) {
      // Finds every reachable proto enum class and registers specific methods for reflection.
      access.registerSubtypeReachabilityHandler(
          (duringAccess, subtypeClass) -> {
            if (!PROTO_ENUM_CLASS.equals(subtypeClass.getName())) {
              Method method =
                  NativeImageUtils.getMethodOrFail(
                      subtypeClass,
                      "valueOf",
                      duringAccess.findClassByName(ENUM_VAL_DESCRIPTOR_CLASS));
              RuntimeReflection.register(method);

              method = NativeImageUtils.getMethodOrFail(subtypeClass, "getValueDescriptor");
              RuntimeReflection.register(method);
            }
          },
          protoEnumClass);
    }
  }

  /** Given a proto class, registers the public accessor methods for the provided proto class. */
  private static void registerFieldAccessors(Class<?> protoClass) {
    for (Method method : protoClass.getMethods()) {
      boolean hasAccessorPrefix =
          METHOD_ACCESSOR_PREFIXES.stream().anyMatch(prefix -> method.getName().startsWith(prefix));
      if (hasAccessorPrefix) {
        RuntimeReflection.register(method);
      }
    }
  }

  /** Given a proto class, returns the Builder nested class. */
  private static Class<?> getBuilderClass(Class<?> protoClass) {
    for (Class<?> clazz : protoClass.getClasses()) {
      if (clazz.getName().endsWith("Builder")) {
        return clazz;
      }
    }
    return null;
  }
}
