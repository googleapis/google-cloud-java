/*
 * Copyright 2023 Google LLC
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

import com.google.cloud.storage.TransportCompatibility.Transport;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

final class CrossTransportUtils {

  static <T> T throwHttpJsonOnly(String methodName) {
    return throwHttpJsonOnly(Storage.class, methodName);
  }

  static <T> T throwHttpJsonOnly(Class<?> clazz, String methodName) {
    return throwTransportOnly(clazz, methodName, Transport.HTTP);
  }

  static <T> T throwGrpcOnly(String methodName) {
    return throwGrpcOnly(Storage.class, methodName);
  }

  static <T> T throwGrpcOnly(Class<?> clazz, String methodName) {
    return throwTransportOnly(clazz, methodName, Transport.GRPC);
  }

  static <T> T throwTransportOnly(Class<?> clazz, String methodName, Transport transport) {
    String builder;
    switch (transport) {
      case HTTP:
        builder = "StorageOptions.http()";
        break;
      case GRPC:
        builder = "StorageOptions.grpc()";
        break;
      default:
        throw new IllegalStateException(
            String.format(
                Locale.US,
                "Broken Java Enum: %s received value: '%s'",
                Transport.class,
                transport));
    }
    String message =
        String.format(
            Locale.US,
            "%s#%s is only supported for %s transport. Please use %s to construct a compatible"
                + " instance.",
            clazz.getName(),
            methodName,
            transport,
            builder);
    throw new UnsupportedOperationException(message);
  }

  static String fmtMethodName(String name, Class<?>... args) {
    return name
        + "("
        + Arrays.stream(args).map(Class::getName).collect(Collectors.joining(", "))
        + ")";
  }
}
