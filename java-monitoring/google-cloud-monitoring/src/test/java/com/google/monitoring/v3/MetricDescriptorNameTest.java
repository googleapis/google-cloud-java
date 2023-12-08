package com.google.monitoring.v3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MetricDescriptorNameTest {

  @Test
  public void name() {
    MetricDescriptorName descriptorName = MetricDescriptorName.parse(
        "projects/foo/metricDescriptors/bar/baz/buz");
    Assert.assertEquals(descriptorName.getFieldValue("metric_descriptor"), "bar/baz/buz");
  }
}