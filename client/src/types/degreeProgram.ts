import { z } from "zod";

import type { Course } from "@/types/course";

interface DegreeProgram {
  name: string;
  slug: string;
  type: DegreeProgramType;
  courses: Course[];
}

const DegreeProgramTypeEnum = z.enum([
  "BACHELOR",
  "MASTER_I",
  "MASTER_II",
  "SINGLE_CYCLE_MASTER",
  "DOCTORAL",
  "SPECIALIZATION",
]);

type DegreeProgramType = z.infer<typeof DegreeProgramTypeEnum>;

const AddDegreeProgramFormSchema = z.object({
  name: z.string().min(2, {
    message: "Degree program name must be at least 2 characters.",
  }),
  type: DegreeProgramTypeEnum,
});

const EditDegreeProgramFormSchema = z.object({});

export {
  AddDegreeProgramFormSchema,
  type DegreeProgram,
  type DegreeProgramType,
  EditDegreeProgramFormSchema,
};
