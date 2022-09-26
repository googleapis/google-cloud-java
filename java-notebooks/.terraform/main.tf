terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "notebooks_api" {
  service            = "notebooks.googleapis.com"
  disable_on_destroy = false
}
