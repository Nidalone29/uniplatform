import type { Course } from "@/types/course";
import type { DegreeProgram } from "@/types/degreeProgram";
import type { University } from "@/types/university";

export type Entities = University | DegreeProgram | Course;

// This is a prop for the forms inside the dialog window when you want to edit a
// University/DegreeProgram/Course...
export interface FormInDialogProps<T extends Entities> {
  formId: string;
  formData?: T;
  closingFunct: (open: boolean) => void;
  formStateFunct?: (open: boolean) => void;
}

export interface DialogProps<T extends Entities> {
  formId: string; // just a passthrough
  data?: T; // just a passthrough (defined for editing)
  CustomForm: React.ComponentType<FormInDialogProps<T>>;
}

export interface DeleteDialogProps<T extends Entities> {
  data: T;
}
