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

package com.google.cloud.storage;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation which is used to convey which Cloud Storage API a class or method has compatibility
 * with.
 *
 * <p>Not all operations are compatible with all transports.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Documented
@Inherited
public @interface TransportCompatibility {

  Transport[] value();

  /**
   * Enum representing the transports {@code com.google.cloud.storage} classes have implementations
   * for.
   */
  enum Transport {
    /**
     * Value indicating use of the <a target="_blank"
     * href="https://cloud.google.com/storage/docs/json_api">Cloud Storage JSON API</a>
     *
     * @see StorageOptions#http()
     */
    HTTP,

    /**
     * Value indicating usa of the <a target="_blank"
     * href="https://github.com/googleapis/googleapis/blob/master/google/storage/v2/storage.proto">Cloud
     * Storage v2 gRPC API</a> TODO: link to public docs when published.
     *
     * @see StorageOptions#grpc()
     */
    GRPC
  }
}
