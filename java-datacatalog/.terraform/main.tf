terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "data_catalog_api" {
  service            = "datacatalog.googleapis.com"
  disable_on_destroy = false
}
