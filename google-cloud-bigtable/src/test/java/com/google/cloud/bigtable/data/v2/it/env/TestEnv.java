/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.it.env;

import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Defines the interface of a target environment.
 *
 * <p>This allows for integration tests to run against either production or an emulator.
 */
public interface TestEnv {
  void start() throws Exception;

  void stop() throws Exception;

  BigtableDataClient getDataClient();

  TableName getTableName();

  String getFamilyId();

  String getRowPrefix();
}
