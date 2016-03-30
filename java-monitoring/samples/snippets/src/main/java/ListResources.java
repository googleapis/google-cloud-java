/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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
// [START all]

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.monitoring.v3.Monitoring;
import com.google.api.services.monitoring.v3.MonitoringScopes;
import com.google.api.services.monitoring.v3.model.ListMetricDescriptorsResponse;
import com.google.api.services.monitoring.v3.model.ListMonitoredResourceDescriptorsResponse;
import com.google.api.services.monitoring.v3.model.ListTimeSeriesResponse;

import org.joda.time.DateTime;

import java.io.IOException;
import java.io.PrintStream;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;


/**
 * Simple command-line program to demonstrate connecting to and retrieving data
 * from the Google Cloud Monitoring API v3 using application default credentials.
 */
public class ListResources {

  /**
   * The metric that we want to fetch.
   */
  private static final String METRIC =
      "compute.googleapis.com/instance/cpu/usage_time";

  /**
   * This test program prints to standard output, but the integration tests verify
   * the output with a custom output stream.
   */
  private PrintStream outputStream;

  /**
   * Cloud Monitoring v3 REST client.
   */
  private Monitoring monitoringService;

  /**
   * Identifier for project resource, in format 'projects/your-project-id'.
   */
  private String projectResource;

  /**
   * Utility class doesn't need to be instantiated.
   */
  private ListResources(Monitoring monitoringService, String projectResource) {
    this.monitoringService = monitoringService;
    this.projectResource = projectResource;
    this.outputStream = System.out;
  }

  /**
   * Package private that accepts output stream for integration test.
   */
  ListResources(Monitoring monitoringService, String projectResource, PrintStream os) {
    this.monitoringService = monitoringService;
    this.projectResource = projectResource;
    this.outputStream = os;
  }

  private static SimpleDateFormat rfc3339 =
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");

  static {
    rfc3339.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  /**
   * Query the projects.monitoredResourceDescriptors.list API method.
   * <p/>
   * <p>This lists all the resources available to be monitored in the API.
   * <p/>
   * <p>Package-private to be accessible to tests.
   */
  void listMonitoredResourceDescriptors() throws IOException {
    ListMonitoredResourceDescriptorsResponse monitoredResources =
        this.monitoringService.projects()
            .monitoredResourceDescriptors().list(this.projectResource).execute();
    this.outputStream.println("listMonitoredResourceDescriptors response");
    this.outputStream.println(monitoredResources.toPrettyString());
  }

  /**
   * Query to MetricDescriptors.list
   * <p>This lists all the current metrics. Package-private to be accessible to tests.
   */
  void listMetricDescriptors() throws IOException {
    ListMetricDescriptorsResponse metricsResponse =
        this.monitoringService.projects().metricDescriptors()
            .list(this.projectResource).execute();
    this.outputStream.println("listMetricDescriptors response");
    this.outputStream.println(metricsResponse.toPrettyString());
  }

  /**
   * Returns start time for listTimeSeries.
   *
   * @return An hour ago - 5 minutes
   */
  private static String getStartTime() {
    // Return an hour ago - 5 minutes
    DateTime dt = new DateTime().minusHours(1).minusMinutes(5);
    rfc3339.format(dt.toDate());
    return rfc3339.format(dt.toDate());
  }

  /**
   * Returns end time for listTimeSeries.
   *
   * @return An hour ago
   */
  private static String getEndTime() {
    // Return an hour ago
    DateTime dt = new DateTime().minusHours(1);
    return rfc3339.format(dt.toDate());
  }


  /**
   * Query to MetricDescriptors.list
   *
   * <p>This lists all the current metrics.
   */
  void listTimeseries() throws IOException {
    ListTimeSeriesResponse timeSeriesList = this.monitoringService.projects().timeSeries()
        .list(this.projectResource)
        .setFilter("metric.type=\"" + METRIC + "\"")
        .setPageSize(3)
        .setIntervalStartTime(getStartTime())
        .setIntervalEndTime(getEndTime())
        .execute();
    this.outputStream.println("listTimeseries response");
    this.outputStream.println(timeSeriesList.toPrettyString());
  }

  /**
   * Builds and returns a CloudMonitoring service object authorized with the
   * application default credentials.
   *
   * @return CloudMonitoring service object that is ready to make requests.
   * @throws GeneralSecurityException if authentication fails.
   * @throws IOException              if authentication fails.
   */
  static Monitoring authenticate() throws GeneralSecurityException, IOException {
    // Grab the Application Default Credentials from the environment.
    GoogleCredential credential = GoogleCredential.getApplicationDefault()
        .createScoped(MonitoringScopes.all());

    // Create and return the CloudMonitoring service object
    HttpTransport httpTransport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();
    Monitoring service = new Monitoring.Builder(httpTransport,
        jsonFactory, credential)
        .setApplicationName("Monitoring Sample")
        .build();
    return service;
  }

  /**
   * Query the Google Cloud Monitoring API using a service account and print the
   * result to the console.
   *
   * @param args The first arg should be the project name you'd like to inspect.
   * @throws Exception if something goes wrong.
   */
  public static void main(final String[] args) throws Exception {
    if (args.length != 1) {
      System.err.println(String.format("Usage: %s <project-name>",
          ListResources.class.getSimpleName()));
      return;
    }

    String project = args[0];
    String projectResource = "projects/" + project;


    // Create an authorized API client
    Monitoring monitoringService = authenticate();

    ListResources example = new ListResources(
        monitoringService, projectResource);

    example.listMonitoredResourceDescriptors();
    example.listMetricDescriptors();
    example.listTimeseries();
  }
}
