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

package com.google.cloud.nativeimage.features.clients;

import com.google.cloud.nativeimage.features.NativeImageUtils;
import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.configure.ResourcesRegistry;
import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeClassInitialization;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/** Registers GraalVM configuration for the Cloud SQL libraries for MySQL and Postgres. */
@AutomaticFeature
final class CloudSqlFeature implements Feature {

  private static final String CLOUD_SQL_SOCKET_CLASS =
      "com.google.cloud.sql.core.CoreSocketFactory";

  private static final String POSTGRES_SOCKET_CLASS = "com.google.cloud.sql.postgres.SocketFactory";

  private static final String MYSQL_SOCKET_CLASS = "com.google.cloud.sql.mysql.SocketFactory";

  @Override
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    if (access.findClassByName(CLOUD_SQL_SOCKET_CLASS) == null) {
      return;
    }

    // The Core Cloud SQL Socket
    NativeImageUtils.registerClassForReflection(access, CLOUD_SQL_SOCKET_CLASS);

    // Resources for Cloud SQL
    ResourcesRegistry resourcesRegistry = ImageSingletons.lookup(ResourcesRegistry.class);
    resourcesRegistry.addResources("\\Qcom.google.cloud.sql/project.properties\\E");
    resourcesRegistry.addResources("\\QMETA-INF/services/java.sql.Driver\\E");

    // Register Hikari configs if used with Cloud SQL.
    if (access.findClassByName("com.zaxxer.hikari.HikariConfig") != null) {
      NativeImageUtils.registerClassForReflection(access, "com.zaxxer.hikari.HikariConfig");

      RuntimeReflection.register(
          access.findClassByName("[Lcom.zaxxer.hikari.util.ConcurrentBag$IConcurrentBagEntry;"));

      RuntimeReflection.register(access.findClassByName("[Ljava.sql.Statement;"));
    }

    // Register PostgreSQL driver config.
    if (access.findClassByName(POSTGRES_SOCKET_CLASS) != null) {
      NativeImageUtils.registerClassForReflection(
          access, "com.google.cloud.sql.postgres.SocketFactory");
      NativeImageUtils.registerClassForReflection(access, "org.postgresql.PGProperty");
    }

    // Register MySQL driver config.
    if (access.findClassByName(MYSQL_SOCKET_CLASS) != null) {
      NativeImageUtils.registerClassForReflection(access, MYSQL_SOCKET_CLASS);

      NativeImageUtils.registerConstructorsForReflection(
          access, "com.mysql.cj.conf.url.SingleConnectionUrl");

      NativeImageUtils.registerConstructorsForReflection(access, "com.mysql.cj.log.StandardLogger");

      access.registerSubtypeReachabilityHandler(
          (duringAccess, exceptionClass) ->
              NativeImageUtils.registerClassForReflection(duringAccess, exceptionClass.getName()),
          access.findClassByName("com.mysql.cj.exceptions.CJException"));

      // JDBC classes create socket connections which must be initialized at run time.
      RuntimeClassInitialization.initializeAtRunTime("com.mysql.cj.jdbc");

      // Additional MySQL resources.
      resourcesRegistry.addResourceBundles("com.mysql.cj.LocalizedErrorMessages");
    }
  }
}
