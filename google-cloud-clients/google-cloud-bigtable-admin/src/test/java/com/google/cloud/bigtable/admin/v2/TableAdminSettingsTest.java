package com.google.cloud.bigtable.admin.v2;

import static com.google.common.truth.Truth.*;

import com.google.api.gax.rpc.StatusCode.Code;
import com.google.bigtable.admin.v2.InstanceName;
import java.io.IOException;
import org.junit.Test;

public class TableAdminSettingsTest {

  @Test
  public void testInstanceName() throws IOException {
    InstanceName instanceName = InstanceName.of("my-project", "my-instance");

    TableAdminSettings.Builder builder = TableAdminSettings.newBuilder()
        .setInstanceName(instanceName);

    assertThat(builder.getInstanceName()).isEqualTo(instanceName);
    assertThat(builder.build().getInstanceName()).isEqualTo(instanceName);
    assertThat(builder.build().toBuilder().getInstanceName()).isEqualTo(instanceName);
  }

  @Test
  public void testMissingInstanceName() {
    Exception actualException = null;

    try {
      TableAdminSettings.newBuilder().build();
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(NullPointerException.class);
  }

  @Test
  public void testStubSettings() throws IOException {
    InstanceName instanceName = InstanceName.of("my-project", "my-instance");

    TableAdminSettings.Builder builder = TableAdminSettings.newBuilder()
        .setInstanceName(instanceName);

    builder.stubSettings().createTableSettings()
        .setRetryableCodes(Code.INVALID_ARGUMENT);

    assertThat(builder.build().getStubSettings().createTableSettings().getRetryableCodes())
        .containsExactly(Code.INVALID_ARGUMENT);

    assertThat(builder.build().toBuilder().build().getStubSettings().createTableSettings()
        .getRetryableCodes())
        .containsExactly(Code.INVALID_ARGUMENT);
  }
}
