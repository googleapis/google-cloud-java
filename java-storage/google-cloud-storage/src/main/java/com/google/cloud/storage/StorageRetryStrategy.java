/*
 * Copyright 2021 Google LLC
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

import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.cloud.BaseService;
import java.io.Serializable;

/**
 * A factory class which is used to provide access to {@link ResultRetryAlgorithm} for idempotent
 * and non-idempotent calls made via {@link Storage}. Before {@link Storage} performs an operation
 * it will determine if the operation is idempotent and select the appropriate {@link
 * ResultRetryAlgorithm} to use for that invocation.
 *
 * @see #getDefaultStorageRetryStrategy()
 * @see #getUniformStorageRetryStrategy()
 */
public interface StorageRetryStrategy extends Serializable {

  /**
   * Factory method to provide a {@link ResultRetryAlgorithm} which will be used to evaluate whether
   * a retry can happen for an operation which has been deemed idempotent.
   *
   * @return
   */
  ResultRetryAlgorithm<?> getIdempotentHandler();

  ResultRetryAlgorithm<?> getNonidempotentHandler();

  /**
   * Factory method to get an instance of the default implementation of {@link
   * StorageRetryStrategy}. The returned instance is provides handler which are appropriate for
   * calls which are known to be idempotent vs non-idempotent.
   *
   * <p>All non-idempotent calls will not be retried
   *
   * <p>The set of retryable cases handled by this strategy is more comprehensive than that of the
   * legacy strategy and should always be preferred.
   *
   * <table>
   *   <caption>Retried HTTP status codes for idempotent calls</caption>
   *   <tr>
   *     <th>Code</th>
   *     <th>Name</th>
   *   </tr>
   *   <tr>
   *     <td>408</td>
   *     <td>Request Timeout</td>
   *   </tr>
   *   <tr>
   *     <td>429</td>
   *     <td>Too Many Requests</td>
   *   </tr>
   *   <tr>
   *     <td>500</td>
   *     <td>Internal Server Error</td>
   *   </tr>
   *   <tr>
   *     <td>502</td>
   *     <td>Bad Gateway</td>
   *   </tr>
   *   <tr>
   *     <td>503</td>
   *     <td>Service Unavailable</td>
   *   </tr>
   *   <tr>
   *     <td>504</td>
   *     <td>Gateway Timeout</td>
   *   </tr>
   * </table>
   *
   * @see StorageOptions.Builder#setStorageRetryStrategy(StorageRetryStrategy)
   * @see #getUniformStorageRetryStrategy()
   */
  static StorageRetryStrategy getDefaultStorageRetryStrategy() {
    return DefaultStorageRetryStrategy.INSTANCE;
  }

  /**
   * Factory method to get an instance of {@link StorageRetryStrategy} which will uniformly retry
   * all calls as if they were idempotent.
   *
   * <p><b><i>NOTE:</i></b>This strategy is unsafe and will result in retying some non-idempotent
   * calls. Care should be taken to ensure calls which would not normally be considered idempotent
   * are made idempotent by some other means in your program.
   *
   * @see StorageOptions.Builder#setStorageRetryStrategy(StorageRetryStrategy)
   * @see #getDefaultStorageRetryStrategy()
   */
  static StorageRetryStrategy getUniformStorageRetryStrategy() {
    return new UniformStorageRetryStrategy(getDefaultStorageRetryStrategy().getIdempotentHandler());
  }

  /**
   * Factory method to get an instance of {@link StorageRetryStrategy} with the behavior which was
   * used prior to version 2.1.8. <b>This strategy is unsafe and will result in retying some
   * non-idempotent calls.</b>
   *
   * @deprecated please migrate to using {@link #getDefaultStorageRetryStrategy()} which is capable
   *     of providing handlers which are appropriate for idempotent and non-idempotent calls.
   * @see StorageOptions.Builder#setStorageRetryStrategy(StorageRetryStrategy)
   * @see #getDefaultStorageRetryStrategy()
   */
  @Deprecated
  static StorageRetryStrategy getLegacyStorageRetryStrategy() {
    return new UniformStorageRetryStrategy(BaseService.EXCEPTION_HANDLER);
  }
}
