terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

provider "google" {
  project = var.project_id
  region  = var.region
  zone    = var.zone
}

resource "google_project_service" "data_catalog_api" {
  service            = "datacatalog.googleapis.com"
  disable_on_destroy = false
}
