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
import com.google.cloud.jdbc.quickperf.config.ConfigParser;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.ArrayUtils;

public class QuickPerf extends Thread {

  private static final String BREAK_STR =
      "###################################################################################################";

  // TODO: make measurement file configurable
  private static final String MEASURES_FILE_NAME = "measures.txt";

  public static void main(String[] args) throws Exception {
    Options options = new Options();

    options.addOption(QuickPerf.addOption("c", "config", true, "Config File"));

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd = null;

    ZonedDateTime testStartTimestamp = ZonedDateTime.now();

    try {
      cmd = parser.parse(options, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp("utility-name", options);

      System.exit(1);
    }

    Config config = ConfigParser.parseConfigFile(cmd.getOptionValue("config"));

    float[] measures = new float[config.getIterations() * config.getThreads()];

    // initialize threads (for sampling if present)
    List<QuickPerfRunner> threadList = new ArrayList<QuickPerfRunner>();
    for (int i = 0; i < config.getThreads(); i++) {
      QuickPerfRunner thread = new QuickPerfRunner(config);
      if (config.getSamplingQuery() != null) {
        thread.runSampling();
      }
      threadList.add(thread);
    }

    // start threads
    for (QuickPerfRunner thread : threadList) {
      thread.start();
    }

    // ProgressBar Tracker Thread
    ProgressTracker progressTracker =
        progressTracker =
            new ProgressTracker(threadList, config.getIterations() * config.getThreads());

    progressTracker.start();
    progressTracker.join();

    int i = 0;
    for (QuickPerfRunner thread : threadList) {
      thread.join();

      if (i == 0) {
        measures = thread.getMeasures();
      } else {
        measures = ArrayUtils.addAll(measures, thread.getMeasures());
      }
      i++;
    }

    // write to file before its sorted
    if (config.getWriteMetricToFile()) {
      try {
        writeMeasuresToFile(measures, MEASURES_FILE_NAME);
      } catch (IOException e) {
        System.err.println("An error occurred while writing the file: " + e.getMessage());
      }
    }

    System.out.println("\n" + BREAK_STR);
    System.out.println("Query: " + config.getQuery());
    System.out.println("Params: " + config.paramsToString());
    System.out.println("Tag: " + Config.DEFAULT_TAG);
    if (config.getBatchSize() > 0) {
      System.out.println("Batching Enabled (size): " + config.getBatchSize());
    }
    System.out.printf("Start: %s End: %s%n", testStartTimestamp, ZonedDateTime.now());
    System.out.printf(
        "Finished with a total of %s runs across %s Threads.\nLatencies (ms):  p50 = %s, p95 = %s, p99 = %s, min = %s,  max = %s%n",
        config.getIterations() * config.getThreads(),
        config.getThreads(),
        calcPerc(measures, 50),
        calcPerc(measures, 95),
        calcPerc(measures, 99),
        getMin(measures),
        getMax(measures));
    System.out.println(BREAK_STR);
  }

  public static Option addOption(String option, String longOption, boolean hasArgs, String desc) {
    Option opt = new Option(option, longOption, hasArgs, desc);
    opt.setRequired(true);

    return opt;
  }

  public static Option addOption(
      String option, String longOption, boolean hasArgs, String desc, boolean required) {
    Option opt = new Option(option, longOption, hasArgs, desc);
    opt.setRequired(required);

    return opt;
  }

  public static float calcPerc(float[] nums, double percentile) {
    int n = nums.length;
    Arrays.sort(nums);

    double index = (percentile / 100) * (n - 1);

    if (index == Math.floor(index)) {
      return nums[(int) index];
    } else {
      int lowerIndex = (int) Math.floor(index);
      int upperIndex = (int) Math.ceil(index);
      float lowerValue = nums[lowerIndex];
      float upperValue = nums[upperIndex];
      return (float) ((1 - (index - lowerIndex)) * lowerValue + (index - lowerIndex) * upperValue);
    }
  }

  public static float getMax(float[] measures) {
    if (measures == null || measures.length == 0) {
      throw new IllegalArgumentException("Array is null or empty");
    }

    Arrays.sort(measures);
    return measures[measures.length - 1];
  }

  public static float getMin(float[] measures) {
    if (measures == null || measures.length == 0) {
      throw new IllegalArgumentException("Array is null or empty");
    }

    Arrays.sort(measures);
    return measures[0];
  }

  public static void writeMeasuresToFile(float[] array, String fileName) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      for (float value : array) {
        writer.write(Float.toString(value));
        writer.newLine();
      }
    }
  }
}
