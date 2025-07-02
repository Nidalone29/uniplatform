import { z } from "zod";

import type { Course } from "@/types/course";

interface DegreeProgram {
  name: string;
  slug: string;
  courses: Course[];
}

const AddDegreeProgramFormSchema = z.object({
  name: z.string().min(2, {
    message: "Degree program name must be at least 2 characters.",
  }),
});

const EditDegreeProgramFormSchema = z.object({});

export {
  AddDegreeProgramFormSchema,
  type DegreeProgram,
  EditDegreeProgramFormSchema,
};
