import { z } from "zod";

import type { DegreeProgram } from "@/types/degreeProgram";

interface University {
  name: string;
  slug: string;
  country_code: string;
  degree_programs: DegreeProgram[];
}

// TODO the schemas will all be eventually generated via https://github.com/orval-labs/orval
const AddUniversityFormSchema = z.object({
  name: z.string().min(2, {
    message: "University name must be at least 2 characters.",
  }),
  country_code: z.string().length(2, {
    message: "University country must be in ISO 3166 alpha 2 format.",
  }),
});

// for now empty
const EditUniversityFormSchema = z.object({});

export { AddUniversityFormSchema, EditUniversityFormSchema, type University };
