import { z } from "zod";

import type { Course } from "@/types/course";

interface DegreeProgram {
  name: string;
  slug: string;
  type: DegreeProgramType;
  duration: number;
  courses: Course[];
}

const degreeProgramTypeLabels = {
  BACHELOR: "Bachelor Degree",
  MASTER_I: "Master Degree (1st level)",
  MASTER_II: "Master Degree (2nd level)",
  SINGLE_CYCLE_MASTER: "Master Degree (Single Cycle)",
  DOCTORAL: "Doctorate (PhD)",
  SPECIALIZATION: "Specialist degree",
} as const;

type DegreeProgramType = keyof typeof degreeProgramTypeLabels;

// I haven't found a better way of doing this than re-specifying all the enum values
const DegreeProgramTypeEnum = z.enum(
  Object.keys(degreeProgramTypeLabels) as [
    DegreeProgramType,
    ...DegreeProgramType[],
  ],
);

const durationSchema = z.coerce
  .number()
  .int()
  .min(1, {
    message: "Degree program must last at least 1 year.",
  })
  .max(10, {
    message: "Degree program can't last more than 10 years.",
  });

const AddDegreeProgramFormSchema = z.object({
  name: z.string().min(2, {
    message: "Degree program name must be at least 2 characters.",
  }),
  type: DegreeProgramTypeEnum,
  duration: durationSchema,
});

const EditDegreeProgramFormSchema = z.object({
  type: DegreeProgramTypeEnum,
  duration: durationSchema,
});

export {
  AddDegreeProgramFormSchema,
  type DegreeProgram,
  type DegreeProgramType,
  degreeProgramTypeLabels,
  EditDegreeProgramFormSchema,
};
