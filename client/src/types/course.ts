import { z } from "zod";

import type { Exam } from "@/types/exam";

interface Course {
  name: string;
  slug: string;
  exams: Exam[];
}

const AddCourseFormSchema = z.object({
  name: z.string().min(2, {
    message: "Course name must be at least 2 characters.",
  }),
});

const EditCourseFormSchema = z.object({});

export { AddCourseFormSchema, type Course, EditCourseFormSchema };
