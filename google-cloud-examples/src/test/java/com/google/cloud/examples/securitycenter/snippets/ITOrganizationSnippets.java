package com.google.cloud.examples.securitycenter.snippets;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

import com.google.cloud.securitycenter.v1.OrganizationName;
import java.io.IOException;
import org.junit.Test;

public class ITOrganizationSnippets {

  @Test
  public void testGetOrganizationSettings() throws IOException {
    assertNotNull(OrganizationSnippets.getOrganizationSettings(getOrganizationId()));
  }

  @Test
  public void testUpdateOrganizationSettings() throws IOException {
    assertTrue(OrganizationSnippets.updateOrganizationSettings(getOrganizationId()).getAssetDiscoveryConfig().isInitialized());
  }

  private static OrganizationName getOrganizationId() {
    return OrganizationName.of(System.getenv("GCLOUD_ORGANIZATION"));
  }

}
