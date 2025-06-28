import { z } from "zod";

interface Exam {
  name: string;
  slug: string;
  ects: number;
}

const ectsSchema = z.coerce
  .number()
  .int()
  .min(1, {
    message: "Exam need to give at least 1 credit.",
  })
  .max(30, {
    message: "Exams can't give more than 30 credits.",
  });

const AddExamFormSchema = z.object({
  name: z.string().min(2, {
    message: "Exam name must be at least 2 characters.",
  }),
  ects: ectsSchema,
});

const EditExamFormSchema = z.object({
  ects: ectsSchema,
});

export { AddExamFormSchema, EditExamFormSchema, type Exam };
