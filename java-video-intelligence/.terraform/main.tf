terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "videointelligence_api" {
  service            = "videointelligence.googleapis.com"
  disable_on_destroy = false
}
