import type { Course } from "./course";

export interface University {
  name: string,
  slug: string,
  courses: Course[]
}
