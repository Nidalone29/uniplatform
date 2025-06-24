import { z } from "zod";
import type { Course } from "./course";

interface University {
  name: string,
  slug: string,
  courses: Course[]
}

// TODO the schemas will all be eventually generated via https://github.com/orval-labs/orval
const AddUniversityFormSchema = z.object({
  name: z.string().min(2, {
    message: "University name must be at least 2 characters.",
  }),
});

// for now empty
const EditUniversityFormSchema = z.object({
});

export { type University, AddUniversityFormSchema, EditUniversityFormSchema };

