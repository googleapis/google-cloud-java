package com.google.cloud.spanner.jdbc.it;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.GceTestEnvConfig;
import com.google.cloud.spanner.SpannerOptions;

public class GceTestEnvConfigWithEmulatorSupport extends GceTestEnvConfig {
  @Override
  public SpannerOptions spannerOptions() {
    SpannerOptions res = super.spannerOptions();
    if(res.getHost() != null && res.getHost().contains("localhost")) {
      if(res.getCredentials() != NoCredentials.getInstance()) {
        res = res.toBuilder().setCredentials(NoCredentials.getInstance()).build();
      }
    }
    return res;
  }
}
