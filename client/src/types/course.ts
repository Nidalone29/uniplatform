import type { Exam } from "./exam";

export interface Course {
  name: string,
  slug: string,
  exams: Exam[]
}
