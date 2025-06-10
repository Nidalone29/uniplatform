import type { Exam } from "./exam";

export interface Course {
  name: string,
  exams: Exam[]
}
