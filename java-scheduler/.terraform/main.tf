terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
    time = {
      source = "hashicorp/time"
    }
  }
}

module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = var.inputs.project_id
  enable_apis                 = true
  disable_services_on_destroy = false
  activate_apis               = [
    "pubsub.googleapis.com",
    "cloudscheduler.googleapis.com",
    "cloudtrace.googleapis.com",
  ]
}
resource "time_sleep" "for_1m_allowServicesTimeToFullyEnable" {
  depends_on      = [module.project-services]
  create_duration = "1m"
}
