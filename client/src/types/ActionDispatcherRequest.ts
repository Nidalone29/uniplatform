import type { z } from "zod";

import { AddCourseFormSchema, EditCourseFormSchema } from "@/types/course";
import {
  AddDegreeProgramFormSchema,
  EditDegreeProgramFormSchema,
} from "@/types/degreeProgram";
import {
  AddUniversityFormSchema,
  EditUniversityFormSchema,
} from "@/types/university";

export type AddContentType =
  | z.infer<typeof AddUniversityFormSchema>
  | z.infer<typeof AddDegreeProgramFormSchema>
  | z.infer<typeof AddCourseFormSchema>;

export type EditContentType =
  | z.infer<typeof EditUniversityFormSchema>
  | z.infer<typeof EditDegreeProgramFormSchema>
  | z.infer<typeof EditCourseFormSchema>;

export type PossibleContentType = AddContentType | EditContentType;

type intentType = "add" | "edit" | "delete";

// Content can be undefined because in delete intent there is no content, only the slug from the component
export interface ActionDispatcherRequest {
  intent: intentType;
  slug?: string;
  content?: PossibleContentType;
}
