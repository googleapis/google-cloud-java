package com.google.cloud.examples.bigquery.snippets.dataset;

import static org.junit.Assert.*;

import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import org.junit.Test;

public class ITDatasetSnippets {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String DATASET_ID = RemoteBigQueryHelper.generateDatasetName();

  @Test
  public void testDatasetSnippets() throws InterruptedException {

    assertNotNull("GOOGLE_CLOUD_PROJECT environment variable not set", PROJECT_ID);

    // Create a new dataset.
    Dataset newDataset = CreateDataset.createDataset(PROJECT_ID, DATASET_ID);
    assertNotNull(newDataset);

    // Get dataset metadata.
    Dataset dataset = GetDataset.getDataset(PROJECT_ID, DATASET_ID);
    assertNotNull("Failed to get dataset " + DATASET_ID, dataset);

    // Update Dataset description.
    String newDescription = "new description";
    assertNotEquals(dataset.getDescription(), newDescription);
    Dataset updated =
        UpdateDatasetDescription.updateDatasetDescription(PROJECT_ID, DATASET_ID, newDescription);
    assertNotNull(updated);
    assertEquals(updated.getDescription(), newDescription);

    // List datasets in the project and assert the new dataset is present.
    Boolean found = false;
    for (Dataset entry : ListDatasets.listDatasets().iterateAll()) {
      if (entry.getDatasetId().getDataset().equals(DATASET_ID)) {
        found = true;
        break;
      }
    }
    assertTrue("Expected dataset " + DATASET_ID + " in list", found);

    // Delete the dataset.
    assertTrue(
        "Failed to delete dataset " + DATASET_ID,
        DeleteDataset.deleteDataset(PROJECT_ID, DATASET_ID, true));
  }
}
