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

import com.google.api.services.monitoring.v3.Monitoring;
import com.google.api.services.monitoring.v3.model.CreateTimeSeriesRequest;
import com.google.api.services.monitoring.v3.model.LabelDescriptor;
import com.google.api.services.monitoring.v3.model.ListMetricDescriptorsResponse;
import com.google.api.services.monitoring.v3.model.ListTimeSeriesResponse;
import com.google.api.services.monitoring.v3.model.Metric;
import com.google.api.services.monitoring.v3.model.MetricDescriptor;
import com.google.api.services.monitoring.v3.model.MonitoredResource;
import com.google.api.services.monitoring.v3.model.Point;
import com.google.api.services.monitoring.v3.model.TimeInterval;
import com.google.api.services.monitoring.v3.model.TimeSeries;
import com.google.api.services.monitoring.v3.model.TypedValue;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import org.joda.time.DateTime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;


/**
 * Class to demonstrate creating a custom metric with Cloud Monitoring.
 * <p/>
 * <p>This class provides a few functions that create a custom GAUGE metric, writes a timeseries
 * value to it, then reads that metric's value back within the last 5 minutes to see the value
 * written.
 */
public class CreateCustomMetric {

  /**
   * Cloud Monitoring v3 REST client.
   */
  private Monitoring monitoringService;

  private static SimpleDateFormat rfc3339 =
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");

  static {
    rfc3339.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  /**
   * Identifier for project resource, in format 'projects/your-project-id'.
   */
  private String projectResource;

  /**
   * All custom metrics should use this domain as their prefix.
   */
  static final String CUSTOM_METRIC_DOMAIN = "custom.googleapis.com";

  /**
   * Name of our custom metric to create.
   */
  static final String DEFAULT_METRIC_TYPE = "custom_measurement";

  /**
   * The specific metric type for the instance of this class. Defaults to DEFAULT_METRIC_TYPE.
   */
  private String metricType;

  /**
   * The specific metric name, which is based on the project resource and the type.
   */
  private String metricName;


  /**
   * GAUGE metrics measure a value at a point in time.
   */
  static final String METRIC_KIND = "GAUGE";

  /**
   * Upper bound for random number to write to metric, defaults to 10.
   */
  private int bound = 10;

  /**
   * Constructs an instance of the class using the default metric name.
   */
  public CreateCustomMetric(Monitoring monitoringService, String projectResource) {
    this.monitoringService = monitoringService;
    this.projectResource = projectResource;
    this.metricType = CUSTOM_METRIC_DOMAIN + "/" + DEFAULT_METRIC_TYPE;
    this.metricName = projectResource + "/metricDescriptors/" + metricType;

  }

  /**
   * Constructs an instance of the class using the default metric name, and takes in a random
   * number generaotr (used for test purposes).
   * <p/>
   * <p>Package-private to be accessible to tests.
   */
  CreateCustomMetric(Monitoring monitoringService, String projectResource,
                     String metricName, int bound) {
    this.monitoringService = monitoringService;
    this.projectResource = projectResource;
    this.metricType = CUSTOM_METRIC_DOMAIN + "/" + DEFAULT_METRIC_TYPE;
    this.metricName = projectResource + "/metricDescriptors/" + metricType;
    this.bound = bound;
  }

  /**
   * Constructs an instance of the class with the metric name specified.
   */
  public CreateCustomMetric(Monitoring monitoringService, String projectResource,
                            String metricName) {
    this.monitoringService = monitoringService;
    this.projectResource = projectResource;
    this.metricType = CUSTOM_METRIC_DOMAIN + "/" + metricName;
    this.metricName = projectResource + "/metricDescriptors/" + metricType;
  }

  /**
   * Returns now in RFC3339 format. This is the end-time of the window
   * this example views the TimeSeries in.
   */
  private static String getNow() {
    DateTime dt = new DateTime();
    return rfc3339.format(dt.toDate());
  }

  /**
   * Returns 5 minutes before now to create a window to view timeseries in.
   */
  private static String getStartTime() {
    DateTime dt = new DateTime().minusMinutes(5);
    return rfc3339.format(dt.toDate());
  }

  /**
   * Dummy method to get an arbitrary data point.
   */
  private long getRandomPoint() {
    long value = new Random().nextInt(bound);
    System.out.println("Returning value " + value);
    return value;
  }

  /**
   * This method creates a custom metric with arbitrary names, description,
   * and units.
   * <p/>
   * <p>Package-private to be accessible to tests.
   */
  MetricDescriptor createCustomMetric() throws IOException {
    MetricDescriptor metricDescriptor = new MetricDescriptor();


    metricDescriptor.setName(metricName);
    metricDescriptor.setType(metricType);

    LabelDescriptor labelDescriptor = new LabelDescriptor();
    labelDescriptor.setKey("environment");
    labelDescriptor.setValueType("STRING");
    labelDescriptor.setDescription("An arbitrary measurement.");
    labelDescriptor.setDescription("Custom Metric");
    List<LabelDescriptor> labelDescriptorList = new ArrayList<LabelDescriptor>();
    labelDescriptorList.add(labelDescriptor);
    metricDescriptor.setLabels(labelDescriptorList);

    metricDescriptor.setMetricKind(METRIC_KIND);
    metricDescriptor.setValueType("INT64");
    // Fake custom metric with unit 'items'
    metricDescriptor.setUnit("items");


    MetricDescriptor descriptorResponse = this.monitoringService.projects()
        .metricDescriptors()
        .create(projectResource, metricDescriptor)
        .execute();
    System.out.println("create response" + descriptorResponse.toPrettyString());
    return descriptorResponse;

  }

  /**
   * Retrieve the custom metric created by createCustomMetric.
   * <p/>
   * <p>It can sometimes take a few moments before a new custom metric is ready to have
   * TimeSeries written to it, so this method is used
   * to check when it is ready.
   */
  public MetricDescriptor getCustomMetric() throws IOException {
    Monitoring.Projects.MetricDescriptors.List metrics =
        monitoringService.projects().metricDescriptors()
            .list(projectResource);
    metrics.setFilter("metric.type=\"" + metricType + "\"");
    ListMetricDescriptorsResponse response = metrics.execute();
    List<MetricDescriptor> descriptors = response.getMetricDescriptors();
    System.out.println("reading custom metric");
    if (descriptors == null || descriptors.isEmpty()) {
      System.out.println("No metric descriptor matching that label found.");
      return null;
    } else {
      System.out.println(descriptors.get(0).toPrettyString());
      return descriptors.get(0);
    }
  }

  /**
   * Writes a timeseries value for the custom metric created.
   * <p>The value written is a random integer value for demonstration purposes. It's a GAUGE metric,
   * which means its a measure of a value at a point in time, and thus the start
   * window and end window times are the same.
   *
   * @throws IOException On network error.
   */
  void writeCustomMetricTimeseriesValue() throws IOException {
    Map<String, String> metricLabel = ImmutableMap.of(
        "environment", "STAGING"
    );
    Map<String, String> resourceLabel = ImmutableMap.of(
        "instance_id", "test-instance",
        "zone", "us-central1-f"
    );

    CreateTimeSeriesRequest timeSeriesRequest = new CreateTimeSeriesRequest();
    TimeSeries timeSeries = new TimeSeries();

    Metric metric = new Metric();
    metric.setType(metricType);

    metric.setLabels(metricLabel);
    timeSeries.setMetric(metric);
    MonitoredResource monitoredResource = new MonitoredResource();
    monitoredResource.setType("gce_instance");
    monitoredResource.setLabels(resourceLabel);
    timeSeries.setResource(monitoredResource);
    Point point = new Point();
    TimeInterval ti = new TimeInterval();
    String now = getNow();
    ti.setStartTime(now);
    ti.setEndTime(now);

    point.setInterval(ti);
    point.setValue(new TypedValue().setInt64Value(getRandomPoint()));

    timeSeries.setPoints(Lists.<Point>newArrayList(point));

    timeSeriesRequest.setTimeSeries(Lists.<TimeSeries>newArrayList(timeSeries));
    monitoringService.projects().timeSeries().create(projectResource, timeSeriesRequest).execute();
  }

  /**
   * Read the TimeSeries value for the custom metrics created within a window of the
   * last 5 minutes.
   *
   * @return The TimeSeries response object reflecting the Timeseries of the custom metrics
   *     for the last 5 minutes.
   * @throws IOException On network error.
   */
  ListTimeSeriesResponse readTimeseriesValue() throws IOException {
    ListTimeSeriesResponse response =
        monitoringService.projects().timeSeries().list(projectResource)
            .setFilter("metric.type=\"" + metricType + "\"")
            .setPageSize(3)
            .setIntervalStartTime(getStartTime())
            .setIntervalEndTime(getNow())
            .execute();
    return response;
  }

  /**
   * Use the Google Cloud Monitoring API to create a custom metric.
   *
   * @param args The first arg should be the project name you'd like to inspect.
   * @throws Exception if something goes wrong.
   */
  public static void main(final String[] args) throws Exception {
    if (args.length != 1) {
      System.err.println(String.format("Usage: %s <project-name>",
          CreateCustomMetric.class.getSimpleName()));
      return;
    }

    String project = args[0];
    String projectResource = "projects/" + project;


    // Create an authorized API client
    Monitoring monitoringService = ListResources.authenticate();

    CreateCustomMetric metricWriter =
        new CreateCustomMetric(monitoringService, projectResource);

    MetricDescriptor metricDescriptor = metricWriter.createCustomMetric();

    System.out.println("listMetricDescriptors response");
    System.out.println(metricDescriptor.toPrettyString());

    // wait until custom metric can be read back
    while (metricWriter.getCustomMetric() == null) {
      Thread.sleep(2000);
    }
    metricWriter.writeCustomMetricTimeseriesValue();
    Thread.sleep(3000);
    ListTimeSeriesResponse response = metricWriter.readTimeseriesValue();
    System.out.println("reading custom metric timeseries");
    System.out.println(response.toPrettyString());

  }
}
