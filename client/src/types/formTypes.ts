import type { Course } from "./course";
import type { Exam } from "./exam";
import type { University } from "./university";

export type Entities = University | Course | Exam;

// This is a prop for the forms inside the dialog window when you want to edit a
// Uni/Course/Exam...
export interface FormInDialogProps<T extends Entities> {
  formId: string,
  formData?: T,
  closingFunct: (open: boolean) => void,
  formStateFunct?: (open: boolean) => void;
}

export interface DialogProps<T extends Entities> {
  formId: string, // just a passthrough
  data?: T, // just a passthrough (defined for editing)
  CustomForm: React.ComponentType<FormInDialogProps<T>>;
}
