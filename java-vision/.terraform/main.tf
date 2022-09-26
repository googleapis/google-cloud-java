terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "vision_api" {
  service            = "vision.googleapis.com"
  disable_on_destroy = false
}
