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

package com.google.cloud.spanner.connection;

/** Option value used for determining the behavior of savepoints. */
public enum SavepointSupport {
  /**
   * Savepoints are enabled and can be used on the connection. Rolling back to a savepoint will
   * trigger a retry of the transaction up to the point where the savepoint was set.
   */
  ENABLED,
  /**
   * Savepoints are enabled and can be used on the connection. Rolling back to a savepoint will not
   * trigger a retry. Further attempts to use a read/write transaction after a rollback to savepoint
   * will fail. This mode can be used for frameworks that require savepoint support, for example if
   * the framework automatically creates a savepoint for a specific feature, but that do not need to
   * support rolling back to a savepoint. This value should also be used for transactions that
   * return non-deterministic data, for example auto-generated primary key values, as retries would
   * always fail. This option will not affect rolling back to a savepoint in a read-only
   * transaction, as those transactions do not require a retry after rolling back to a savepoint.
   */
  FAIL_AFTER_ROLLBACK,
  /** Savepoints are disabled. Any attempt to create a savepoint will fail. */
  DISABLED {
    @Override
    public boolean isSavepointCreationAllowed() {
      return false;
    }
  };

  /** Returns true if this mode allows the creation of savepoints. */
  public boolean isSavepointCreationAllowed() {
    return true;
  }
}
