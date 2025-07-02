import { z } from "zod";

interface Course {
  name: string;
  slug: string;
  ects: number;
}

const ectsSchema = z.coerce
  .number()
  .int()
  .min(1, {
    message: "Course need to give at least 1 credit.",
  })
  .max(30, {
    message: "Course can't give more than 30 credits.",
  });

const AddCourseFormSchema = z.object({
  name: z.string().min(2, {
    message: "Course name must be at least 2 characters.",
  }),
  ects: ectsSchema,
});

const EditCourseFormSchema = z.object({
  ects: ectsSchema,
});

export { AddCourseFormSchema, type Course, EditCourseFormSchema };
