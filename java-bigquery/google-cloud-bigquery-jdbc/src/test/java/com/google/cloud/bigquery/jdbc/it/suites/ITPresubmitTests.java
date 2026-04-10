/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.it.suites;

import com.google.cloud.bigquery.jdbc.it.ITAuthTests;
import com.google.cloud.bigquery.jdbc.it.ITBigQueryJDBCTest;
import com.google.cloud.bigquery.jdbc.it.ITCallableStatementTest;
import com.google.cloud.bigquery.jdbc.it.ITConnectionPoolingTest;
import com.google.cloud.bigquery.jdbc.it.ITConnectionTest;
import com.google.cloud.bigquery.jdbc.it.ITDatabaseMetadataTest;
import com.google.cloud.bigquery.jdbc.it.ITDriverTest;
import com.google.cloud.bigquery.jdbc.it.ITResultSetMetadataTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
  ITAuthTests.class,
  ITBigQueryJDBCTest.class,
  ITCallableStatementTest.class,
  ITConnectionTest.class,
  ITConnectionPoolingTest.class,
  ITDatabaseMetadataTest.class,
  ITDriverTest.class,
  ITResultSetMetadataTest.class
})
public class ITPresubmitTests {}
