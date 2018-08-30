package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny;
import com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.MultiClusterRoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.SingleClusterRoutingPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateAppProfileRequestTest {
  @Test
  public void testToProto() {
    CreateAppProfileRequest wrapper = CreateAppProfileRequest.of("my-instance", "my-profile")
        .setDescription("my description")
        .setRoutingPolicy(
            SingleClusterRoutingPolicy.of("my-cluster", true)
        )
        .setIgnoreWarnings(true);

    assertThat(wrapper.toProto(ProjectName.of("my-project"))).isEqualTo(
        com.google.bigtable.admin.v2.CreateAppProfileRequest.newBuilder()
            .setParent(InstanceName.of("my-project", "my-instance").toString())
            .setAppProfileId("my-profile")
            .setAppProfile(
                com.google.bigtable.admin.v2.AppProfile.newBuilder()
                    .setDescription("my description")
                    .setSingleClusterRouting(
                        SingleClusterRouting.newBuilder()
                            .setClusterId("my-cluster")
                            .setAllowTransactionalWrites(true)
                    )
            )
            .setIgnoreWarnings(true)
            .build()
    );
  }

  @Test
  public void testMultiClusterRouting() {
    CreateAppProfileRequest wrapper = CreateAppProfileRequest.of("my-instance", "my-profile")
        .setRoutingPolicy(MultiClusterRoutingPolicy.of());

    assertThat(wrapper.toProto(ProjectName.of("my-project")).getAppProfile()
        .getMultiClusterRoutingUseAny())
        .isEqualTo(MultiClusterRoutingUseAny.getDefaultInstance());
  }

  @Test
  public void testDefaultDescription() {
    CreateAppProfileRequest wrapper = CreateAppProfileRequest.of("my-instance", "my-profile")
        .setRoutingPolicy(MultiClusterRoutingPolicy.of());

    assertThat(wrapper.toProto(ProjectName.of("my-project")).getAppProfile().getDescription())
        .isEqualTo(
            "my-profile"
        );
  }
}