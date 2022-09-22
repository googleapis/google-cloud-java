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

resource "google_project_service" "error_reporting_api" {
  service            = "clouderrorreporting.googleapis.com"
  disable_on_destroy = false
}
