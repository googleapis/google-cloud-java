terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "datalabeling_api" {
  service            = "datalabeling.googleapis.com"
  disable_on_destroy = false
}

