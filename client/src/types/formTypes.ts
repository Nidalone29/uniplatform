import type { Course } from "./course";
import type { Exam } from "./exam";
import type { University } from "./university";

export type Entities = University | Course | Exam;

// This is a prop for the forms inside the dialog window when you want to edit a
// Uni/Course/Exam...
export interface FormInDialogProps<T extends Entities> {
  formData: T,
  closingFunct: (open: boolean) => void,
  reFetchUpdatedData?: (updatedData: T) => void;
}
