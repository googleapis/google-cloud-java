/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.jdbc.quickperf;

import com.google.cloud.jdbc.quickperf.config.Config;
import com.google.cloud.jdbc.quickperf.config.QueryParam;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.jdbc.CloudSpannerJdbcConnection;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.datafaker.Faker;

public class QuickPerfRunner extends Thread {
  private static final Properties DEFAULT_PROPERTIES = new Properties();

  // perf measurement
  private float[] measures;

  private final List<String> sampledValueList = new ArrayList<String>();
  private final Config config;

  private int progress;

  public QuickPerfRunner(Config config) {
    this.config = config;
  }

  public void runSampling() {
    System.out.println("Running Sampling... ");

    try (Connection connection = createConnection(config)) {
      try (Statement statement = connection.createStatement()) {
        boolean hasResults = statement.execute(config.getSamplingQuery());

        if (!hasResults) {
          System.out.println("Nothing sampled");
          return;
        }

        ResultSet rs = statement.getResultSet();
        while (rs.next()) {
          String value = rs.getString(1);
          sampledValueList.add(value);
        }

        System.out.printf("Finished sampling %s records%n", sampledValueList.size());
      } catch (SQLException e) {
        //noinspection CallToPrintStackTrace
        e.printStackTrace();
      }

    } catch (SQLException e) {
      //noinspection CallToPrintStackTrace
      e.printStackTrace();
    }
  }

  private Connection createConnection(Config config) throws SQLException {
    String connectionUrl = createConnectionURL(config);
    Properties properties = createConnectionProperties();
    return DriverManager.getConnection(connectionUrl, properties);
  }

  private String createConnectionURL(Config config) {
    if (config.isIsEmulator()) {
      return String.format(
          "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s?autoConfigEmulator=true",
          config.getProject(), config.getInstance(), config.getDatabase());
    } else {
      return String.format(
          "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
          config.getProject(), config.getInstance(), config.getDatabase());
    }
  }

  private Properties createConnectionProperties() {
    if (System.getProperty("spanner.host") != null) {
      Properties properties = new Properties();
      properties.setProperty("endpoint", System.getProperty("spanner.host"));
      return properties;
    }
    return DEFAULT_PROPERTIES;
  }

  public void run() {
    if (config.getBatchSize() > 0) {
      int val = (int) Math.ceil((double) config.getIterations() / config.getBatchSize());
      measures = new float[val];
    } else {
      measures = new float[config.getIterations()];
    }

    try (Connection connection = createConnection(config)) {

      // determine database dialect to set right tagging syntax
      boolean isGoogleSQL =
          connection
              .unwrap(CloudSpannerJdbcConnection.class)
              .getDialect()
              .equals(Dialect.GOOGLE_STANDARD_SQL);
      String tagPrefix = isGoogleSQL ? "" : "SPANNER.";

      connection.setAutoCommit(false);

      // if there is DML switch to r/w transaction mode and apply transaction tagging.
      // Otherwise set to read-only mode.
      if (config.getQuery().contains("INSERT")
          || config.getQuery().contains("UPDATE")
          || config.getQuery().contains("DELETE")) {
        // read-write
        connection.createStatement().execute("SET TRANSACTION READ WRITE");
        connection
            .createStatement()
            .execute(String.format("SET %sTRANSACTION_TAG = '%s'", tagPrefix, config.DEFAULT_TAG));

      } else {
        // read-only
        // connection.createStatement().execute("SET TRANSACTION READ ONLY");
        connection.setAutoCommit(true);
      }

      PreparedStatement statement = connection.prepareStatement(config.getQuery());
      int batchCounter = config.getBatchSize();
      int batchRound = 0;

      for (int i = 0; i < config.getIterations(); i++) {
        if (config.getBatchSize() == 0) {
          // single statements
          try {
            if (config.getQueryParams() != null) {
              parametrizeStatement(statement, config.getQueryParams());
            }
            connection
                .createStatement()
                .execute(String.format("SET %sSTATEMENT_TAG='%s'", tagPrefix, config.DEFAULT_TAG));

            long start = System.nanoTime();
            boolean hasResults = statement.execute();
            if (!connection.getAutoCommit()) {
              connection.commit();
              connection
                .createStatement()
                .execute(String.format("SET %sTRANSACTION_TAG = '%s'", tagPrefix, config.DEFAULT_TAG));
            }
            long stop = System.nanoTime() - start;

            if (hasResults) {
              statement.getResultSet().close();
            }

            measures[i] = (float) stop / 1000000;
            progress++;
          } catch (Exception e) {
            if (e.getMessage().contains("ALREADY_EXISTS:")) {
              System.out.println("duplicate key - retry");
              i--;
            } else {
              throw e;
            }
          }
        } else if (config.getQuery().contains("INSERT")
            || config.getQuery().contains("UPDATE")
            || config.getQuery().contains("DELETE")) {
          // batching
          try {
            if (config.getQueryParams() != null) {
              parametrizeStatement(statement, config.getQueryParams());
            }

            statement.addBatch();

            if (batchCounter == 0 || i == config.getIterations() - 1) {
              connection
                  .createStatement()
                  .execute(
                      String.format("SET %sSTATEMENT_TAG='%s'", tagPrefix, config.DEFAULT_TAG));

              long start = System.nanoTime();
              statement.executeBatch();
              if (!connection.getAutoCommit()) {
                connection.commit();
              }
              long stop = System.nanoTime() - start;

              batchCounter = config.getBatchSize();

              measures[batchRound] = (float) stop / 1000000;
              batchRound++;
            }

            progress++;
            batchCounter--;
          } catch (Exception e) {
            if (e.getMessage().contains("ALREADY_EXISTS:")) {
              System.out.println("duplicate key - retry");
              i--;
            } else {
              throw e;
            }
          }
        } else {
          System.out.println(
              "Batching is only allowed for DML. Set batchSize=0 to disable batching.");
          System.exit(1);
        }
      }
    } catch (SQLException e) {
      //noinspection CallToPrintStackTrace
      e.printStackTrace();
    }
  }

  public static float[] appendFloatArray(float[] originalArray, float[] elementsToAppend) {
    int originalLength = originalArray.length;
    int elementsLength = elementsToAppend.length;

    float[] resultArray = new float[originalLength + elementsLength];
    System.arraycopy(originalArray, 0, resultArray, 0, originalLength);
    System.arraycopy(elementsToAppend, 0, resultArray, originalLength, elementsLength);

    return resultArray;
  }

  private void parametrizeStatement(PreparedStatement statement, List<QueryParam> paramList)
      throws SQLException {
    for (QueryParam param : paramList) {
      if (param.getValue().contains("#i")) {
        // integer plus integer with custom range
        int value = replaceInt(param.getValue());
        statement.setInt(param.getOrder(), value);
      } else if (param.getValue().contains("#d")) {
        // double
        Double value = replaceDouble(param.getValue());
        statement.setDouble(param.getOrder(), value);
      } else if (param.getValue().contains("#s")) {
        // String
        String value = replaceString(param.getValue());
        statement.setString(param.getOrder(), value);
      } else if (param.getValue().contains("#ps")) {
        // Sampled Query - String
        String value = replaceSampleQueryString(param.getValue());
        statement.setString(param.getOrder(), value);
      } else if (param.getValue().contains("#pi")) {
        // Sampled Query - Integer
        Long value = replaceSampleQueryInt(param.getValue());
        statement.setLong(param.getOrder(), value);
      }
    }
  }

  private int replaceInt(String value) {
    Faker f = new Faker();
    // integer with min, max
    String pattern = "#i\\((\\d+),(\\d+)\\)#";
    Pattern regexPattern = Pattern.compile(pattern);
    Matcher matcher = regexPattern.matcher(value);

    if (matcher.find()) {
      int min = Integer.parseInt(matcher.group(1));
      int max = Integer.parseInt(matcher.group(2));

      return f.number().numberBetween(min, max);
    }

    return Integer.parseInt(
        value.replaceFirst("#i", String.valueOf(new SecureRandom().nextInt(Integer.MAX_VALUE))));
  }

  private Double replaceDouble(String value) {
    Faker f = new Faker();

    return Double.valueOf(
        value.replaceFirst("#d", String.valueOf(f.number().randomDouble(2, 0, 999999999))));
  }

  private String replaceString(String value) {
    return value.replaceFirst("#s", UUID.randomUUID().toString());
  }

  private String replaceSampleQueryString(String value) {
    int randomIndex = new Random().nextInt(sampledValueList.size());
    return value.replaceFirst("#ps", sampledValueList.get(randomIndex));
  }

  private Long replaceSampleQueryInt(String value) {
    int randomIndex = new Random().nextInt(sampledValueList.size());

    return Long.parseLong(value.replaceFirst("#pi", sampledValueList.get(randomIndex)));
  }

  public int getProgress() {
    return progress;
  }

  public float[] getMeasures() {
    return measures;
  }
}
